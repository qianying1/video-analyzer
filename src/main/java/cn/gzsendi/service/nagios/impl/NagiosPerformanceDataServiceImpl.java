package cn.gzsendi.service.nagios.impl;

import cn.gzsendi.cache.nagios.NagiosDataAnalyzeRuleCache;
import cn.gzsendi.mapper.ejb3.SendiCollectIndexMapper;
import cn.gzsendi.mapper.nagios.HostCheckMapper;
import cn.gzsendi.mapper.nagios.ServiceCheckMapper;
import cn.gzsendi.model.nagios.NagiosDataAnalyzeRule;
import cn.gzsendi.model.nagios.NagiosServiceCheck;
import cn.gzsendi.model.sendi.SendiCollectIndex;
import cn.gzsendi.model.sendi.SendiPerformanceData;
import cn.gzsendi.service.nagios.NagiosPerformanceDataService;
import cn.gzsendi.utils.PropertiesUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Nacht
 * Created on 28/11/2018
 */
@Service("nagiosPerformanceDataService")
public class NagiosPerformanceDataServiceImpl implements NagiosPerformanceDataService {
    private static Logger logger = Logger.getLogger(NagiosPerformanceDataServiceImpl.class);
    @Autowired
    ServiceCheckMapper serviceCheckMapper;
    @Autowired
    HostCheckMapper hostCheckMapper;
    @Value("${runtime.cache.file.absolute.path}")
    String runtimeCacheAbsolutePath;
    @Autowired
    NagiosDataAnalyzeRuleCache nagiosDataAnalyzeRuleCache;
    @Autowired
    SendiCollectIndexMapper sendiCollectIndexMapper;

    @Override
    public String getLastestPerformanceData() {
        try {
            int lastQueryId = Integer.valueOf(PropertiesUtil.getProperty(runtimeCacheAbsolutePath, "nagios_service_check_last_process_id"));
            List<NagiosServiceCheck> nagiosServiceChecks = serviceCheckMapper.listServiceChecksByLastQueryId(lastQueryId+1);
            if(nagiosServiceChecks == null || nagiosServiceChecks.isEmpty()){
                logger.info("查询时间:"+new Date()+"上一次查询id:"+lastQueryId+",当前没有新数据,接口将返回null");
                return null;
            }
            List<SendiPerformanceData> sendiPerformanceDatas = this.tranformNagiosDataToSendiData(nagiosServiceChecks);
            int currentLastQueryId = this.getMaxNagiosServiceCheckId(nagiosServiceChecks);
            logger.info("查询时间:"+new Date()+"上一次查询id:"+lastQueryId+"最新一次查询id:"+currentLastQueryId+",共"+nagiosServiceChecks.size()+"条数据,共生成"+sendiPerformanceDatas.size()+"条性能数据");
            PropertiesUtil.setProperty(runtimeCacheAbsolutePath, "nagios_service_check_last_process_id", String.valueOf(currentLastQueryId));
            return JSONObject.toJSONString(sendiPerformanceDatas);
        } catch (Exception e) {
            logger.error("获取nagios性能数据时发生了一个异常,异常详情:", e);
            return "获取nagios性能数据时发生了一个异常,异常详情"+e.getMessage();
        }
    }


    /**
     * 根据nagios性能数据中的关键字(PING,HTTP等等)匹配nagios_data_analyze_rule中的规则进行解析,并转换成原有网管系统的格式
     *
     * @param nagiosServiceChecks
     * @return
     */
    private List<SendiPerformanceData> tranformNagiosDataToSendiData(List<NagiosServiceCheck> nagiosServiceChecks) {
        List<SendiPerformanceData> resultList = new ArrayList<SendiPerformanceData>();
        for (NagiosServiceCheck nagiosServiceCheck : nagiosServiceChecks) {
            String rawOutput = nagiosServiceCheck.getOutput();
            List<NagiosDataAnalyzeRule> analyzeRules = nagiosDataAnalyzeRuleCache.getNagiosAnalyzeRulesByRawData(rawOutput);
            if (analyzeRules.isEmpty()) {
                logger.info("性能数据:" + nagiosServiceCheck.toString() + "找不到对应的解析规则.");
                continue;
            }
            for (NagiosDataAnalyzeRule analyzeRule : analyzeRules) {
                String extractExpression = analyzeRule.getValueExtractExpression();
                int collectIndexId = analyzeRule.getCollectIndexId();
                String hostName = nagiosServiceCheck.getHostName();
                String hostIp = nagiosServiceCheck.getHostIp();
                SendiCollectIndex sendiCollectIndex = sendiCollectIndexMapper.getCollectIndexById(collectIndexId);
                if (sendiCollectIndex == null) {
                    logger.info("解析规则:" + analyzeRule.toString() + "找不到对应的指标信息.");
                    continue;
                }
                try {
                    Double value = this.extractValue(extractExpression, rawOutput);
                    if (value == null) {
                        logger.info("解析规则:" + analyzeRule.toString() + ",原始性能数据:" + rawOutput + ",无法解析原始数据,请检查正则表达式配置是否正确.");
                        continue;
                    }
                    SendiPerformanceData sendiPerformanceData = new SendiPerformanceData();
                    String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    Map<String, Object> performance = new HashMap<String, Object>();
                    performance.put("name",sendiCollectIndex.getNameEn());
                    performance.put("value", value);
                    List<Map<String, Object>> performanceList = new ArrayList<Map<String, Object>>();
                    performanceList.add(performance);
                    String id = hostName;
                    String name = hostName;
                    String ip = hostIp;
                    int state = 0;
                    sendiPerformanceData.setPerformance(performanceList);
                    sendiPerformanceData.setId(id);
                    sendiPerformanceData.setName(name);
                    sendiPerformanceData.setIp(ip);
                    sendiPerformanceData.setStartTime(startTime);
                    sendiPerformanceData.setState(state);
                    resultList.add(sendiPerformanceData);
                } catch (Exception e) {
                    logger.info("解析规则:" + analyzeRule.toString() + ",原始性能数据:" + rawOutput + ",解析过程中发生了一个错误,错误详情:", e);
                    continue;
                }
            }
        }
        return resultList;
    }

    /**
     * 根据正则表达式从nagios性能数据中提取指标值
     * @param extractExpression
     * @param rawOutput
     * @return
     */
    private Double extractValue(String extractExpression, String rawOutput) {
        Pattern pattern = Pattern.compile(extractExpression);
        Matcher matcher = pattern.matcher(rawOutput);
        if(matcher.find()){
            return Double.valueOf(matcher.group(1));
        }
        return null ;
    }

    /**
     * 获取该查询后最后一条数据的主键,下次查询从该主键的下一条开始取数据
     * @param nagiosServiceChecks
     * @return
     */
    private int getMaxNagiosServiceCheckId(List<NagiosServiceCheck> nagiosServiceChecks) {
        Collections.sort(nagiosServiceChecks, new Comparator<NagiosServiceCheck>() {
            @Override
            public int compare(NagiosServiceCheck o1, NagiosServiceCheck o2) {
                if(o1.getServiceCheckId() < o2.getServiceCheckId()){
                    return 1;
                }else if(o1.getServiceCheckId() == o2.getServiceCheckId()){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        return nagiosServiceChecks.get(0).getServiceCheckId();
    }
}
