/*
package cn.gzsendi.config.thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

*/
/**
 * 视图配置
 *//*

@Configuration
public class ViewConfig {
    */
/**
     * 设置视图解析器
     *
     * @param templateEngine
     * @return
     *//*

    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine);
        return resolver;
    }

    */
/**
     * 设置模板引擎
     *
     * @param templateResolver
     * @return
     *//*

    @Bean
    public SpringTemplateEngine templateEngine(TemplateResolver templateResolver) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);
        return engine;
    }

    */
/**
     * 模板解析引擎
     *
     * @return
     *//*

    @Bean
    public TemplateResolver templateResolver() {
        TemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("/src/main/webapp/WEB-INF/templates/");//设置地址前缀
        resolver.setSuffix(".html");//设置后缀
        resolver.setCacheable(false);//设置不缓存
        resolver.setTemplateMode("HTML5");
        return resolver;

    }
}
*/
