package cn.gzsendi.controller;

import cn.gzsendi.service.nagios.NagiosPerformanceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Nacht
 * Created on 04/12/2018
 */
@RestController
public class NagiosPerformanceDataController {
    @Autowired
    NagiosPerformanceDataService nagiosPerformanceDataService;

    @RequestMapping(value = "/nagios/performance/since_last_query")
    public String getNagiosPerformanceDate(){
        return nagiosPerformanceDataService.getLastestPerformanceData();
    }
}
