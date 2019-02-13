package cn.gzsendi.model.sendi;

import java.util.List;
import java.util.Map;

/**
 * @Author Nacht
 * Created on 30/11/2018
 */
public class SendiPerformanceData {
    private List<Map<String,Object>> performance;
    private String id ;
    private String name ;
    private String ip;
    private String startTime;
    private int state ;

    public List<Map<String, Object>> getPerformance() {
        return performance;
    }

    public void setPerformance(List<Map<String, Object>> performance) {
        this.performance = performance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SendiPerformanceData{" +
                "performance=" + performance +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", startTime='" + startTime + '\'' +
                ", state=" + state +
                '}';
    }
}
