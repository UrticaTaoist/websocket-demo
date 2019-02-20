package cn.luutqf.spring.websocket.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ZhenYang
 * @Date Created in 2018/3/9 11:10
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocketMsg {
    private String message;
    private String code;
    private Integer type;
    private String token;
    private String cookies;
}
