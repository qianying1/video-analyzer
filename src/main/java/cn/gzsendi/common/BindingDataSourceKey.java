package cn.gzsendi.common;

/**
 * ThreadLocal用于在每次进行数据库访问操作时存储该线程所访问的数据源名称
 * AbstractRoutingDataSource的实现类会根据每个线程对应的数据源名称动态切换数据源
 * @Author Nacht
 * Created on 30/11/2018
 */
public class BindingDataSourceKey {
    private static final ThreadLocal<String> THREAD_LOCAL_TOKEN = new ThreadLocal<String>();

    public static String getDataSourceToken() {
        return THREAD_LOCAL_TOKEN.get();
    }

    public static void setDataSourceToken(String dataSource) {
        THREAD_LOCAL_TOKEN.set(dataSource);
    }

    public static void clearDataSourceToken() {
        THREAD_LOCAL_TOKEN.remove();
    }

}
