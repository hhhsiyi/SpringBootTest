package com.hewen.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//相当于Spring中的 applicationcontext.xml
public class ConfigBean {
    @Bean
    //    配置负载均衡实现restTemplate
    @LoadBalanced //ribbon负载均衡：可以让服务通过服务名去访问，就可以访问一堆同名的节点了，ribbon的作用就是这个
//    客户端可以直接调用，不用担心我们的ip地址和端口号
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
