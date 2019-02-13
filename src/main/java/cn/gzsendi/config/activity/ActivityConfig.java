package cn.gzsendi.config.activity;

import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * 工作流属性参数配置
 */
@Configuration
public class ActivityConfig extends AbstractProcessEngineAutoConfiguration {

    @Resource(name = "activityDataSource")
    private DataSource activityDataSource;

    /**
     * 事务管理器
     */
    @Autowired
    PlatformTransactionManager activityTransactionManager;

    /**
     * 配置自定义的工作流数据源
     *
     * @param springAsyncExecutor
     * @return
     * @throws IOException
     */
    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(SpringAsyncExecutor springAsyncExecutor) throws IOException {
        System.out.println(activityTransactionManager);
        return this.baseSpringProcessEngineConfiguration(activityDataSource, activityTransactionManager, springAsyncExecutor);
    }
}
