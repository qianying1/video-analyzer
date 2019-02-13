package cn.gzsendi.service.sendi;

import java.util.Map;

/**
 * 网管库主机信息接口
 * @Author Nacht
 * Created on 28/11/2018
 */
public interface SendiHostService {

    /**
     * 主机信息同步接口,用于同步外部系统的主机数据
     * map入参:
     * key:description => value:主机名称
     * key:hostname => value:主机ip地址
     * key:template => value:主机所属类别
     * key:bigtemplate => value:主机所属大类
     * @param params
     */
    public void importOutSystemHost(Map<String,Object> params);
}
