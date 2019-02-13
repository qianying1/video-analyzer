package cn.gzsendi.config.security;

import cn.gzsendi.controller.security.SysAuthenticationProvider;
import cn.gzsendi.service.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * SpringSecurity登陆页面访问权限配置
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationService authenticationServiceImpl;
    @Resource(name = "userTokenDataSource")
    private DataSource userTokenDataSource;
    @Autowired
    private SysAuthenticationProvider sysAuthenticationProvider;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private AuthenticationFailHander authenticationFailHander;

    /**
     * 配置系统默认页面路径拦截器
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        //登陆页面路径
        http.formLogin().loginPage("/user/login")
                //登陆表单提交地址
                .loginProcessingUrl("/user/login-form")
                //登陆成功处理逻辑
                .successHandler(authenticationSuccessHandler)
                //登陆失败处理逻辑
                .failureHandler(authenticationFailHander)
                //登陆失败页面路径
                .failureUrl("/user/login").permitAll().and()
                //记住
                .rememberMe()
                .rememberMeParameter("remember-me").userDetailsService(authenticationServiceImpl)
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60).and()
                //除了登陆页面外所有页面都需要进行登陆认证
                .authorizeRequests().anyRequest().access("@permissionServiceImpl.hasPermission(request,authentication)")/*.authenticated()*/
                .and()
                .csrf().disable();
    }

    /**
     * 配置系统用户认证器
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.authenticationProvider(sysAuthenticationProvider);
    }

    /**
     * 记住我功能的token存取器配置
     *
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(userTokenDataSource);
        return tokenRepository;
    }
}
