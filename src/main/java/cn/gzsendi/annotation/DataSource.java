package cn.gzsendi.annotation;

import java.lang.annotation.*;

/**
 * 自定义datasource注解,用于动态切换mybatis数据源
 *
 * @Author Nacht
 * Created on 30/11/2018
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    String value();

    String EJB3 = "ejb3DataSource";

    String NAGIOS = "nagiosDataSource";

    String SENDINMDB = "sendiDataSource";

    String USERTOKEN = "userTokenDataSource";

    String ACTIVITY = "activityDataSource";

}
