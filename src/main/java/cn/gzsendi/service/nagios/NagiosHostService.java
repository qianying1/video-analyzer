package cn.gzsendi.service.nagios;

import cn.gzsendi.model.nagios.NagiosHost;

/**
 * nagios主机信息操作接口
 * @Author Nacht
 * Created on 28/11/2018
 */
public interface NagiosHostService {
    /**
     * 将nagios库中的主机信息同步到网管库
     */
    public void syncHostInfoFromNagiosToSendiDB();
}
