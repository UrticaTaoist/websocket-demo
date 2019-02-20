package cn.luutqf.spring.websocket.server.controller.web;

import cn.luutqf.spring.websocket.server.constant.Params;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author ZhenYang
 * @Date Created in 2018/3/8 17:26
 * @Description
 */
@Controller
public class MainController {

    @GetMapping(value = "index")
    public String index(HttpSession httpSession){
        Params.httpSession = httpSession;
        httpSession.setAttribute("xxx","成功思密达");
        return "websocket.html";
    }
    @GetMapping(value = "test1")
    public @ResponseBody
    String test1(HttpSession httpSession){
        return httpSession.getAttribute("xxx").toString();
    }
}
