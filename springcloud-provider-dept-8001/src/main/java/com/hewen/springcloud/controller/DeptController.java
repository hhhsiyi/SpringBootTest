package com.hewen.springcloud.controller;

import com.hewen.springcloud.pojo.Dept;
import com.hewen.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//提供RestFul服务！
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    //    @PostMapping("/dept/add")//用get去提交东西不安全
//    public boolean addDept(Dept dept) {
//        return deptService.addDept(dept);
//    }
    @PostMapping("/dept/add")//用get去提交东西不安全
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    //TODO如果出现用restFul方式传递参数却丢失值的情情况，请添加@RequestBody注解
    @GetMapping("/dept/add")//用get去提交东西不安全
    public boolean addDept1(Dept dept) {

        return deptService.addDept(dept);
    }

    //http://localhost:8001/dept/get/1
    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    //http://localhost:8001/dept/queryAll
    @GetMapping("/dept/queryAll")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    @Autowired//用来获取一些注册中心的信息
    private DiscoveryClient discoveryClient;

    @RequestMapping("/dept/t1")
    public Object discovery() {
        //获取微服务列表清单
        //一般自动注册注册接口就行
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery->" + services);
        //获取一个具体的微服务信息,通过applicationname去拿
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances
        ) {
            System.out.println(instance.getHost()+" "
                    +instance.getPort()+" "
                    +instance.getUri()+" "
            +instance.getServiceId());
        }
        return this.discoveryClient;
    }
    @RequestMapping("/testRest")
    public String t(){
        System.out.println("1");
        return "2";
    }
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/testRest2")
    public void tt(){
        String url ="http://localhost:8001/testRest";
        String url2="http://SPRINGCLOUD-PROVIDER-DEPT/testRest";
        String forObject = (String)restTemplate.getForObject(url2,String.class);
        System.out.println("\n"+forObject);
    }

}
