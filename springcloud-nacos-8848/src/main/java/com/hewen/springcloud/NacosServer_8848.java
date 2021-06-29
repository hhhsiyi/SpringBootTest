package com.hewen.springcloud;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2021/6/22
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
//@NacosPropertySource(dataId = "hewen_test",autoRefreshed = true)
public class NacosServer_8848 {
    public static void main(String[] args) {
        SpringApplication.run(NacosServer_8848.class,args);
    }
    @NacosValue(value = "${service.name:1}", autoRefreshed = true)
    private String serverName;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return serverName;
    }

}
