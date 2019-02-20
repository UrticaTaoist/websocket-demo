package cn.luutqf.spring.websocket.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author: ZhenYang
 * @date: 2019/2/18
 * @description:
 */
@Configuration
public class RedisConfig {

//    @Bean(name = {"redisTemplate", "stringRedisTemplate"})
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate redisTemplate = new StringRedisTemplate();
//        redisTemplate.setConnectionFactory(factory);
//        return redisTemplate;
//    }

    @Bean
    public RedisTemplate redisTemplate (RedisConnectionFactory factory){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

}