package com.hewen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableZuulProxy
public class Zuul_3060 {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_3060.class,args);
    }

}
