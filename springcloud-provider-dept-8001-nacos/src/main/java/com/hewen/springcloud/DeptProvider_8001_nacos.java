package com.hewen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 2021/12/1
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@SpringBootApplication//(exclude = EurekaClient.class)
//@EnableEurekaClient//在服务启动后自动注册到eureka中
@EnableDiscoveryClient
public class DeptProvider_8001_nacos {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001_nacos.class,args);
    }
    //用了这个注解之后，可以通过服务名去调用，默认是轮询
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
//https://nacos.io/zh-cn/docs/quick-start-spring-cloud.html
    @RestController
    class EchoController {
        @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
        public String echo(@PathVariable String string) {
            return "Hello Nacos Discovery " + string;
        }
    }
}
