package cn.gzsendi.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 认证业务接口
 */
public interface AuthenticationService extends UserDetailsService{

}
