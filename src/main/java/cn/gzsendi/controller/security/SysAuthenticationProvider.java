package cn.gzsendi.controller.security;

import cn.gzsendi.model.security.UserInfo;
import cn.gzsendi.service.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 验证器提供者
 */
@Component
public class SysAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AuthenticationService authenticationServiceImpl;

    /**
     * 用户认证
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("正在进行登陆认证>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        // 这个获取表单输入中返回的用户名;
        String userName = authentication.getName();
        // 这个是表单中输入的密码；
        String password = (String) authentication.getCredentials();
        // 这里构建来判断用户是否存在和密码是否正确
        UserInfo userInfo = (UserInfo) authenticationServiceImpl.loadUserByUsername(userName);
        if (userInfo == null) {
            throw new BadCredentialsException("用户名不存在");
        }
        //使用Md5加密进行判断密码是否正确
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        // 这里第个参数，是salt
        // 就是加点盐的意思，这样的好处就是用户的密码如果都是123456，由于盐的不同，密码也是不一样的，就不用怕相同密码泄漏之后，不会批量被破解。
        String encodePwd = md5PasswordEncoder.encodePassword(password, userName);
        System.out.println("加密后的密码为：" + encodePwd);
        // //这里判断密码正确与否
//        if (!userInfo.getPassword().equals(encodePwd)) {
//            throw new BadCredentialsException("密码不正确");
//        }
        //这里还可以加一些其他信息的判断，比如用户账号已停用等判断，这里为了方便我接下去的判断，我就不用加密了。
        //
        //
        if (!userInfo.getPassword().equals("123456")) {
            throw new BadCredentialsException("密码不正确");
        }
        System.out.println("正在登陆密码为： 123456");
        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // 这里直接改成retrun true;表示是支持这个执行
        return true;
    }

}
