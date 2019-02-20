package cn.luutqf.spring.websocket.server.controller.socket;


//import cn.luutqf.spring.websocket.server.config.GetHttpSessionConfigurator;
import cn.luutqf.spring.websocket.server.constant.Params;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author ZhenYang
 * @Date Created in 2018/2/19 3:58
 * @Description
 */

@ServerEndpoint(value = "/websocket"/*,configurator = GetHttpSessionConfigurator.class,decoders = ServerDecoder.class*//*,encoders = ServerEncoder.class*/)
@Component
public class WebSocketServer {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    public static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    public static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    public Session session;




    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.session = session;

        System.out.println("the session is : "+session.getId());

        System.out.println("session content is : "+session.getId());
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
//        ServletActionContext servletActionContext ;
        try {
            //sendMessage(CommonConstant.CURRENT_WANGING_NUMBER.toString());
//            System.out.println(Params.httpSession.getAttribute("xxx"));
            sendMessage("22222222");
        } catch (IOException e) {
            System.out.println("IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        System.out.println(this.session.getId()+":这个断开");
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
//        HttpServletRequest request =
//        System.out.println(httpSession.getAttribute("xxx"));
        System.out.println("来自客户端的消息:" + message);
        System.out.println("onMessage sessionId is : "+session.getId());
        try {
            sendMessage("干啥？");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //群发消息
//        for (WebSocketServer item : webSocketSet) {
//            try {
//                item.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println(error.getMessage());
    }

    /**
     * 给当前用户发送消息
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        System.out.println(Params.httpSession.getAttribute("xxx")+"发送信息?");
        this.session.getBasicRemote().sendText(message+" : sendMessage id is : "+this.session.getId());
        //this.session.getAsyncRemote().sendText(message);
    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message) throws IOException {
        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}