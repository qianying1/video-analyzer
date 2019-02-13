package cn.gzsendi.cache;

import javax.annotation.PostConstruct;
import java.util.Observable;
import java.util.Observer;

/**
 * 通用缓存类,该类的所有子类的bean会自动被系统缓存调度中心纳入调度
 * @Author Nacht
 * Created on 2018/4/16
 */
public abstract class CommonCache implements Observer{
    /**缓存是否需要更新*/
    public abstract boolean isNeedToBeUpdated();
    /**更新缓存*/
    public abstract void updateCache();

    /**
     * spring初始化时自动调用,启动系统时从数据库读取缓存
     */
    @PostConstruct
    private void init(){
//        this.updateCache();
    }

    /**
     * 接收到缓存调度中心通知时调用
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg){
        if(this.isNeedToBeUpdated()){
            this.updateCache();
        }
    }
}
