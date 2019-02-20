package cn.luutqf.spring.websocket.common.utils;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Author ZhenYang
 * @Date Created in 2018/2/19 23:51
 * @Description
 */
public class WebSocketClientUtil {
    public static WebSocketClient getWebSocketClient(String uri) {
        WebSocketClient client = null;
        try {
            client = new WebSocketClient(new URI(uri), new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    System.out.println("打开链接");
                }

                @Override
                public void onMessage(String s) {
                    System.out.println("收到消息" + s);
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    System.out.println("链接已关闭");
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                    System.out.println("发生错误已关闭");
                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        client.connect();
        return client;
    }
}
