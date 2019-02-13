package cn.gzsendi.task.nagios;

import cn.gzsendi.service.nagios.NagiosHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务,将nagios中的主机信息同步到网管库
 * @Author Nacht
 * Created on 28/11/2018
 */
@Component
@EnableScheduling
public class NagiosHostSyncTask {

    @Autowired
    NagiosHostService nagiosHostService;

    /*@Scheduled(fixedRate = 60*60*1000)
    public void scheduled(){
       nagiosHostService.syncHostInfoFromNagiosToSendiDB();
    }*/
}
