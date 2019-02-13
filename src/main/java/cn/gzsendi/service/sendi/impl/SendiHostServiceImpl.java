package cn.gzsendi.service.sendi.impl;

import cn.gzsendi.mapper.ejb3.SendiHostMapper;
import cn.gzsendi.model.sendi.SendiHost;
import cn.gzsendi.service.sendi.SendiHostService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 网管库主机信息接口实现类
 * @Author Nacht
 * Created on 28/11/2018
 */
@Service("sendiHostService")
public class SendiHostServiceImpl implements SendiHostService {

    @Autowired
    SendiHostMapper sendiHostMapper;

    @Override
    public void importOutSystemHost( Map<String, Object> params ) {
        String description = MapUtils.getString(params,"description");
        String hostname = MapUtils.getString(params,"hostname");
        String template = MapUtils.getString(params,"template");
        String bigtemplate = MapUtils.getString(params,"bigtemplate");
        int outSystemId = MapUtils.getInteger(params,"outSystemId");
        String applicationModel = MapUtils.getString(params,"applicationModel");
        String business = MapUtils.getString(params,"business");
        String cabinetsmark = MapUtils.getString(params,"cabinetsmark");
        String location = MapUtils.getString(params,"location");
        String platform = MapUtils.getString(params,"platform");
        String maintenanceunit = MapUtils.getString(params,"maintenanceunit");
        String disabled = MapUtils.getString(params,"disabled");
        String realHostId = MapUtils.getString(params,"realHostId");
        String vcenter = MapUtils.getString(params,"vcenter");
        String vmId = MapUtils.getString(params,"vmId");
        SendiHost sendiHost = new SendiHost();
        sendiHost.setDescription(description);
        sendiHost.setHostname(hostname);
        sendiHost.setTemplate(template);
        sendiHost.setBigtemplate(bigtemplate);
        sendiHost.setOutSystemId(outSystemId);
        sendiHost.setApplicationmodel(applicationModel);
        sendiHost.setBusiness(business);
        sendiHost.setCabinetsmark(cabinetsmark);
        sendiHost.setLocation(location);
        sendiHost.setPlatform(platform);
        sendiHost.setMaintenanceunit(maintenanceunit);
        sendiHost.setDisabled(disabled);
        sendiHost.setRealhostid(realHostId);
        Date currentDate = new Date();
        sendiHost.setLastmodifytime(new SimpleDateFormat("yyyyMMddHHmmss").format(currentDate));
        sendiHost.setLastModifyDate(currentDate);
        sendiHost.setVcenter(vcenter);
        sendiHost.setVmid(vmId);
        sendiHostMapper.insertHost(sendiHost);
    }
}
