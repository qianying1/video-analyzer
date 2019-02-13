package cn.gzsendi.controller.movie;

import cn.gzsendi.service.bilibili.IndexAnalyzer;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 视频控制器
 */
@Controller(value = "movieController")
@RequestMapping(value = "/movie", produces = {"application/json"})
public class MovieController {

    @Autowired
    private IndexAnalyzer indexAnalyzer;
    /**
     * 获取单个电影信息
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public
    @ResponseBody
    Object getMovie(String name) {
        Object resultO=null;
        try {
            resultO=indexAnalyzer.index();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("请求参数为： " + name);
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("msg", "查询成功！");
        result.put("result",resultO);
        return result;
    }
}
