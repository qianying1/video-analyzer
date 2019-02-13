package cn.gzsendi.cache;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Observable;

/**
 * 系统缓存调度中心,定时通知各个缓存进行更新
 * @Author Nacht
 * Created on 2018/4/16
 */
@Component
public class SystemCacheScheduler extends Observable{

    private static Logger logger = Logger.getLogger(SystemCacheScheduler.class);

    @Autowired
    List<CommonCache> systemCaches ;

    /**
     * spring初始化时调用,让各个缓存订阅缓存调度中心的通知
     */
    @PostConstruct
    public void initObservers(){
        for(CommonCache cache:systemCaches){
            this.addObserver(cache);
        }
    }

    /**
     * 通知各系统缓存判断自身缓存是否需要更新,如果需要更新则进行更新操作
     */
     public void notifySystemCaches(){
         logger.info("正在通知系统各个模块的缓存,到达更新周期的缓存将进行更新");
         this.setChanged();
         this.notifyObservers();
     }

}
