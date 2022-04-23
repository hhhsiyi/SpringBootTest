package com.hewen.utils;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * ClassName RedisController
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/3/26 22:12
 */
@RestController
@Slf4j
public class RedisController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private final Logger logger = LoggerFactory.getLogger(RedisController.class);

    @RequestMapping("/hello")
    public String hello() {
        Long views = redisTemplate.opsForValue().increment("views");
        logger.info("該页面被访问{} 次",views);
        return "該页面被访问" + views + " 次";
    }
}
