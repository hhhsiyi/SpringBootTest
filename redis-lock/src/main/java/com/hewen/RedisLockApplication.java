package com.hewen;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * ClassName com.hewen.RedisLockApplication
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/1/3 12:03
 */
@SpringBootApplication
public class RedisLockApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisLockApplication.class, args);
    }
//nginx反向代理之后
    //https://www.cnblogs.com/jiangwangxiang/p/8481661.html
    //nginx反向代理网址学习
    @Bean
    public Redisson redisson() {
        Config config = new Config();
//        单机
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }

}
