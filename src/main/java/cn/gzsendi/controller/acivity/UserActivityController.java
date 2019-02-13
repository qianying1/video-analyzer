package cn.gzsendi.controller.acivity;

import com.alibaba.fastjson.JSONObject;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户工作流控制器
 */
@Controller(value = "userActivityController")
@RequestMapping(value = "/user-activity")
public class UserActivityController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    /**
     * 工作流demo测试接口
     *
     * @return
     */
    @GetMapping(value = "/hello")
    public @ResponseBody Object sayHello() {
        try {
            String pId = runtimeService.startProcessInstanceByKey("sayHelloProcess").getId();
            Task task = taskService.createTaskQuery().processInstanceId(pId).singleResult();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 200);
            jsonObject.put("msg", "say hello process task id : " + task.getId());
            return jsonObject;
        }catch (Exception e){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("code",500);
            jsonObject.put("msg","sayHello 错误!");
            return jsonObject;
        }
    }

}
