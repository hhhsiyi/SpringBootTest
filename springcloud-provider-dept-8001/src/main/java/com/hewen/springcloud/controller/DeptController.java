package com.hewen.springcloud.controller;

import com.hewen.springcloud.pojo.Dept;
import com.hewen.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
