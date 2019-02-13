package cn.gzsendi.service.nagios.impl;

import cn.gzsendi.mapper.nagios.NagiosHostMapper;
import cn.gzsendi.model.nagios.NagiosHost;
import cn.gzsendi.service.nagios.NagiosHostService;
import cn.gzsendi.service.sendi.SendiHostService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * nagios主机信息操作service
 * @Author Nacht
 * Created on 28/11/2018
 */
@Service("nagiosHostService")
public class NagiosHostServiceImpl implements NagiosHostService {

    private static Logger logger = Logger.getLogger(NagiosHostServiceImpl.class);

    @Autowired
    SendiHostService sendiHostService;
    @Autowired
    NagiosHostMapper nagiosHostMapper;

    @Override
    public void syncHostInfoFromNagiosToSendiDB() {
        List<NagiosHost> nagiosHosts = nagiosHostMapper.listAllHosts();
        for(NagiosHost nagiosHost : nagiosHosts) {
            Map<String, Object> params = new HashMap<String, Object>();
            int outSystemId = nagiosHost.getHostId();
            String description = nagiosHost.getAlias();
            String hostname = nagiosHost.getAddress();
            String template = "Nagios主机";
            String bigtemplate = "主机";
            String applicationModel = "N/A";
            String business = "N/A";
            String cabinetsmark = "N/A";
            String location = "N/A";
            String platform = "N/A";
            String maintenanceunit = "N/A";
            String disabled = "off";
            String realHostId = "N/A";
            String vcenter = "N/A";
            String vmId = "N/A";
            params.put("outSystemId",outSystemId);
            params.put("description", description);
            params.put("hostname", hostname);
            params.put("template", template);
            params.put("bigtemplate", bigtemplate);
            params.put("applicationModel",applicationModel);
            params.put("business",business);
            params.put("cabinetsmark",cabinetsmark);
            params.put("location",location);
            params.put("platform",platform);
            params.put("maintenanceunit",maintenanceunit);
            params.put("disabled",disabled);
            params.put("realHostId",realHostId);
            params.put("vcenter",vcenter);
            params.put("vmId",vmId);
            try {
                logger.info("正在同步id为"+outSystemId+"的主机信息到网管库");
                sendiHostService.importOutSystemHost(params);
                logger.info("id为"+outSystemId+"的主机信息成功同步到网管库");
            }catch (Exception e){
                logger.error("同步id为"+outSystemId+"的主机信息到网管库时发生了一个错误,错误详情:",e);
            }
        }
    }
}
