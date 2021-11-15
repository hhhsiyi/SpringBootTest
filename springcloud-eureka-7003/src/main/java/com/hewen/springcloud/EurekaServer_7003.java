package com.hewen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 2021/11/12
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@SpringBootApplication
@EnableEurekaServer//服务端的启动类
public class EurekaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7003.class,args);
    }
}
