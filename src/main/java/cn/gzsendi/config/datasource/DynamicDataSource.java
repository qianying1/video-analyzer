package cn.gzsendi.config.datasource;

import cn.gzsendi.common.BindingDataSourceKey;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 用于数据源动态分配
 * @Author Nacht
 * Created on 30/11/2018
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = BindingDataSourceKey.getDataSourceToken();
        // 获取完后解除绑定，防止其他的service方法调用该数据源
        BindingDataSourceKey.clearDataSourceToken();
        return dataSource;
    }
}
