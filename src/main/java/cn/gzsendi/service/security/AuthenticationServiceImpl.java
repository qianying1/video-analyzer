package cn.gzsendi.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import cn.gzsendi.model.security.UserInfo;

/**
 * 认证业务实现
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    /**
     * 通过用户名加载用户信息
     *
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("正在进行用户信息加载： 用户名为："+username);
        //这里可以通过数据库来查找到实际的用户信息，这里我们先模拟下,后续我们用数据库来实现
        if (username.equals("admin")) {
            //假设返回的用户信息如下;
            UserInfo userInfo = new UserInfo("admin", "123456", "ROLE_ADMIN", true, true, true, true);
            return userInfo;
        }
        return null;
    }
}
