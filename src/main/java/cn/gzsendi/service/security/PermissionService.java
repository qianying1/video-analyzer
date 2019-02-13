package cn.gzsendi.service.security;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限服务接口
 */
public interface PermissionService {

    /**
     * 是否有相关权限
     *
     * @param request
     * @param authentication
     * @return
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
