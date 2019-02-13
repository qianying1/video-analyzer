package cn.gzsendi.cache.sendi;

import cn.gzsendi.cache.CommonCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



/**
 * 主机信息缓存类
 * @Author Nacht
 * Created on 26/11/2018
 */
@Component
public class HostInfoCache extends CommonCache {
    private static Logger logger  = LoggerFactory.getLogger(HostInfoCache.class);
    @Override
    public boolean isNeedToBeUpdated() {
        return false;
    }

    @Override
    public void updateCache() {

    }
}
