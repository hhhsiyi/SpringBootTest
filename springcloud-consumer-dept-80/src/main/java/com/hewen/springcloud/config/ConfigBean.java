package com.hewen.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//相当于Spring中的 applicationcontext.xml
public class ConfigBean {
    @Bean
    //    配置负载均衡实现restTemplate
    @LoadBalanced
//    ribbon已经被eureka废弃了，现在直接用默认loadbalance
//    ribbon负载均衡：可以让服务通过服务名去访问，就可以访问一堆同名的节点了，ribbon的作用就是这个
//    客户端可以直接调用，不用担心我们的ip地址和端口号
//    ribbon默认是轮询的，详情IRule
//    IRule
//    RoundRobinRule轮询
//    Roundom随机
//    Retry：如果服务获取失败，会在指定的时间内重试
//    AvailablilityFilteringRule：会先过滤掉有问题的
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
//
//    @Bean
//    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
//                                                            LoadBalancerClientFactory loadBalancerClientFactory){
//        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//        return new RandomLoadBalancer(loadBalancerClientFactory
//                .getLazyProvider(name, ServiceInstanceListSupplier.class),
//                name);
//    }

}
