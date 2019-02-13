package cn.gzsendi.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源配置类
 *
 * @Author Nacht
 * Created on 30/11/2018
 */
@Configuration
@MapperScan(basePackages = "cn.gzsendi.mapper.*", sqlSessionTemplateRef = "routeSqlSessionTemplate")
public class RouteDataSourceConfig {

    @Bean(name = "ejb3DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ejb3")
    public DataSource ejb3DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "nagiosDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.nagios")
    public DataSource nagiosDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "sendiDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sendi")
    public DataSource sendiDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 工作流数据源
     *
     * @return
     */
    @Bean(name = "activityDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.activity")
    public DataSource activityDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 用户token存储的数据源
     *
     * @return
     */
    @Bean(name = "userTokenDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user_token")
    public DataSource tokenDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "routeDataSource")
    @Primary
    public DataSource routeDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setDefaultTargetDataSource(this.ejb3DataSource());
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put("ejb3DataSource", ejb3DataSource());
        targetDataSources.put("nagiosDataSource", nagiosDataSource());
        targetDataSources.put("sendiDataSource", sendiDataSource());
        targetDataSources.put("userTokenDataSource", tokenDataSource());
        targetDataSources.put("activityDataSource", activityDataSource());
        dataSource.setTargetDataSources(targetDataSources);
        return dataSource;
    }

    @Bean(name = "routeSqlSessionFactory")
    public SqlSessionFactory routeSqlSessionFactory(@Qualifier("routeDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/sqlmapper/*/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "routeTransactionManager")
    public DataSourceTransactionManager routeTransactionManager(@Qualifier("routeDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "routeSqlSessionTemplate")
    public SqlSessionTemplate nagiosSqlSessionTemplate(@Qualifier("routeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
