package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient//在服务启动后自动注册到eureka中
public class DeptProvider_8001_Hystrix {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001_Hystrix.class,args);
    }
    //用了这个注解之后，可以通过服务名去调用，默认是轮询
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
