package cn.gzsendi.config.rest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 进行httpclient相关属性配置
 */
@Configuration
@Component
@ConfigurationProperties(prefix = "http-pool")
@Data
public class HttpPoolProperties {

    @Value("${http-pool.max-total}")
    private Integer maxTotal;
    @Value("${http-pool.default-max-per-route}")
    private Integer defaultMaxPerRoute;
    @Value("${http-pool.connect-timeout}")
    private Integer connectTimeout;
    @Value("${http-pool.connection-request-timeout}")
    private Integer connectionRequestTimeout;
    @Value("${http-pool.socket-timeout}")
    private Integer socketTimeout;
    @Value("${http-pool.validate-after-inactivity}")
    private Integer validateAfterInactivity;

    public HttpPoolProperties(){}

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getDefaultMaxPerRoute() {
        return defaultMaxPerRoute;
    }

    public void setDefaultMaxPerRoute(Integer defaultMaxPerRoute) {
        this.defaultMaxPerRoute = defaultMaxPerRoute;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(Integer connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public Integer getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public Integer getValidateAfterInactivity() {
        return validateAfterInactivity;
    }

    public void setValidateAfterInactivity(Integer validateAfterInactivity) {
        this.validateAfterInactivity = validateAfterInactivity;
    }
}
