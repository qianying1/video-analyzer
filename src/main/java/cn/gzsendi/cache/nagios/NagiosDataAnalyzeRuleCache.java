package cn.gzsendi.cache.nagios;

import cn.gzsendi.cache.CommonCache;
import cn.gzsendi.common.Constants;
import cn.gzsendi.mapper.ejb3.NagiosDataAnalyzeRuleMapper;
import cn.gzsendi.model.nagios.NagiosDataAnalyzeRule;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * nagios数据解析规则缓存
 * @Author Nacht
 * Created on 30/11/2018
 */
@Component
public class NagiosDataAnalyzeRuleCache extends CommonCache {
    private  List<NagiosDataAnalyzeRule> nagiosDataAnalyzeRules ;
    private static Logger logger = Logger.getLogger(NagiosDataAnalyzeRuleCache.class);
    private long lastUpdateTime = 0L;
    @Autowired
    NagiosDataAnalyzeRuleMapper nagiosDataAnalyzeRuleMapper;
    @Override
    public boolean isNeedToBeUpdated() {
        if(nagiosDataAnalyzeRules == null || System.currentTimeMillis() - lastUpdateTime > Constants.NAGIOS_DATA_ANALYZE_RULE_CACHE_UPDATE_INTERVAL){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void updateCache() {
        try {
            logger.info("正在更新nagios数据解析规则缓存");
            this.nagiosDataAnalyzeRules = nagiosDataAnalyzeRuleMapper.listRules();
            lastUpdateTime = System.currentTimeMillis();
            logger.info("nagios数据解析规则缓存更新完成");
        }catch (Exception e){
            logger.error("更新nagios数据解析规则缓存时发生了一个错误,错误详情:",e);
        }
    }


    /**
     * 根据原始的性能数据信息匹配关键字,获取相关的解析规则集合
     * @param rawOutput
     * @return
     */
    public List<NagiosDataAnalyzeRule> getNagiosAnalyzeRulesByRawData(String rawOutput) {
        List<NagiosDataAnalyzeRule> resultList = new ArrayList<NagiosDataAnalyzeRule>();
        for(NagiosDataAnalyzeRule nagiosDataAnalyzeRule:nagiosDataAnalyzeRules ){
            Pattern pattern  = Pattern.compile(nagiosDataAnalyzeRule.getMatchExpression());
            Matcher matcher = pattern.matcher(rawOutput);
            if(matcher.find()){
                resultList.add(nagiosDataAnalyzeRule);
            }
        }
        return resultList;
    }
}
