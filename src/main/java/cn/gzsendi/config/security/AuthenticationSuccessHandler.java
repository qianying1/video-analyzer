package cn.gzsendi.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登陆成功处理器
 */
@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 当用户登陆成功后的处理逻辑
     *
     * @param request
     * @param response
     * @param authentication
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        Map<String, String> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "登录成功");
//        response.setContentType("application/json;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(map));

        //进行首页跳转
        new DefaultRedirectStrategy().sendRedirect(request, response, "/user/index");
    }
}
