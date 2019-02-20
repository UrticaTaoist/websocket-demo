//package cn.luutqf.spring.websocket.server.config;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import javax.websocket.HandshakeResponse;
//import javax.websocket.server.HandshakeRequest;
//import javax.websocket.server.ServerEndpointConfig;
//
///**
// * @Author ZhenYang
// * @Date Created in 2018/2/19 3:59
// * @Description
// */
//@Component
//public class GetHttpSessionConfigurator extends ServerEndpointConfig.Configurator {
//    @Override
//    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
//        HttpSession httpSession = (HttpSession) request.getHttpSession();
//        //解决httpSession为null的情况
//        if (httpSession == null) {
//            HttpServletRequest request2 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            httpSession = request2.getSession();
////            httpSession = Params.httpSession;
//        }
//        sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
//    }
//}
//
