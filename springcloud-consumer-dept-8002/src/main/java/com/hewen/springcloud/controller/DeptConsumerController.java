package com.hewen.springcloud.controller;

import com.hewen.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//@Controller
//写成Controller会报错No message available，切换成RestController即可
@RestController
public class DeptConsumerController {
    //TODO 理解以下：消费者，不应该有service层，可用RestFul
    //RestTemplate。。。。供我们直接调用，需要注册到Spring中
    //(url，请求实体Map，Class<T>responseType)
    //之后注入使用
    @Autowired
    private RestTemplate restTemplate;
    //到底什么是RestTemplate呢，说到底，就是提供多种便捷访问远程http服务的方法，简单的restFul服务模板

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @RequestMapping("consumer/dept/add")
    public boolean addDept(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("consumer/dept/add1")
    public boolean addDept1(Dept dept) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/add", Boolean.class);
    }

    @RequestMapping("consumer/dept/get/{id}")//用get去提交东西不安全
    //TODO要去模拟http://localhost:8001/dept/get/1这样的请求
    public Dept queryById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("consumer/dept/queryAll")//用get去提交东西不安全
    //TODO要去模拟http://localhost:8001/dept/get/1这样的请求
    public List<Dept> queryAll() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/queryAll", List.class);
    }

}
