package cn.gzsendi.service.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限服务接口实现
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 判断当前用户是否有相关权限
     *
     * @param request
     * @param authentication
     * @return
     */
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        System.out.println("正在进行权限检查>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;
        if (principal instanceof UserDetails) { //首先判断先当前用户是否是我们UserDetails对象。
            String userName = ((UserDetails) principal).getUsername();
            Set<String> urls = new HashSet<>(); // 数据库读取 //读取用户所拥有权限的所有URL

            urls.add("/bilibili/movie/get");
            urls.add("/bilibili/user/index");
            urls.add("/bilibili/user-activity/hello");
            // 注意这里不能用equal来判断，因为有些URL是有参数的，所以要用AntPathMatcher来比较
            System.out.println("正在请求的目标地址为："+request.getRequestURI());
            for (String url : urls) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
