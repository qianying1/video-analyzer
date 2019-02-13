package cn.gzsendi.aop;

import cn.gzsendi.annotation.DataSource;
import cn.gzsendi.common.BindingDataSourceKey;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Mapper切面,拦截数据库访问方法并注入@DataSource注解中配置的数据源名称
 * @Author Nacht
 * Created on 30/11/2018
 */
@Aspect
@Component
@Order(0)
public class DataSourceAspect {
    @Pointcut("execution(public * cn.gzsendi.mapper..*.*(..))")
    public void dataSourcePointCut(){};


    /**
     * 拦截目标方法,通过注解来获取数据源名称key值，设置到ThreadLocal中
     */
    @Before("dataSourcePointCut()")
    public void intercept(JoinPoint point) throws Exception {
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        // 使用目标注解类型，如果没有，则使用其接口指定类型
        for (Class<?> clazz : target.getInterfaces()) {
            resolveDataSource(clazz, signature.getMethod());
        }
        resolveDataSource(target, signature.getMethod());
    }

    /**
     * 获取目标对象方法注解和类型注解中的注解
     */
    private void resolveDataSource(Class<?> clazz, Method method) {
        try {
            Class<?>[] types = method.getParameterTypes();
            // 默认使用类型注解
            if (clazz.isAnnotationPresent(DataSource.class)) {
                DataSource cds = clazz.getAnnotation(DataSource.class);
                BindingDataSourceKey.setDataSourceToken(cds.value());
            }
            // 方法注解覆盖，以方法注解为最后值
            Method m = clazz.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource cds = m.getAnnotation(DataSource.class);
                BindingDataSourceKey.setDataSourceToken(cds.value());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

