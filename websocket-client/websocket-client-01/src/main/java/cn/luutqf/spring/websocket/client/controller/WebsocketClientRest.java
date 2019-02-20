package cn.luutqf.spring.websocket.client.controller;

import cn.luutqf.spring.websocket.common.constant.BasicParameter;
import cn.luutqf.spring.websocket.common.utils.WebSocketClientUtil;
import org.java_websocket.client.WebSocketClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ZhenYang
 * @Date Created in 2018/2/19 23:48
 * @Description
 */
@RestController
@RequestMapping("/")
public class WebsocketClientRest {
    public static WebSocketClient client;

    @RequestMapping("init/{sid}")
    public void initConnect(@PathVariable(value = "sid") Integer sid) {
        client = WebSocketClientUtil.getWebSocketClient(BasicParameter.WebSocketServerURI+sid);
        System.out.println(client.getDraft());
//        while (!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
//            System.out.println("还没有打开");
//        }
//        System.out.println("打开了");
    }

    @PostMapping("send")
    public void send() {
//        String str = JSON.toJSONString(user);
        try {
            client.send("asdfsadfdsfas");
        }catch (Exception e){
            System.out.println("连接失败");
        }

    }
    @GetMapping("test")
    public Object test(String path){
        return path;
    }
    @RequestMapping("closeSocket")
    public void close(){
        client.close();
    }
}