package cn.gzsendi.controller.user;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户控制器
 */
@Controller(value = "userController")
@RequestMapping(value = "/user"/*, headers = {"token_id", "accessible"}*//*, produces = {"application/json"}*/)
public class UserController {

    /**
     * 用户登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 用户登陆表单提交
     *
     * @return
     */
    @PostMapping(value = "/login-form"/*, headers = {"token_id", "login-id"}*/, produces = {"application/json"})
    public @ResponseBody
    Object login_form(String username, String password) {
        System.out.println("登陆用户：" + username + " 密码： " + password);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "200");
        jsonObject.put("msg", "登陆成功!");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonObject.put("result", JSONObject.parseObject("{\"username\":\"" + username + "\",\"login_time\":\"" + dateFormat.format(new Date()) + "\"}"));
        return jsonObject;
    }

    /**
     * 登陆失败跳转的页面
     *
     * @return
     */
    @GetMapping(value = "/login-error")
    public String login_error() {
        return "login-error";
    }

    /**
     * 登陆成功后进行首页跳转
     *
     * @return
     */
    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }
}
