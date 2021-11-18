package com.hewen.springcloud.service;

import com.hewen.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 2021/11/18
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
// 这个里面配的就是微服务的名字
@Component
public interface DeptClientService {
    @PostMapping("dept/get/{id}")
    public Dept queryById(@PathVariable("id")long id);
    @PostMapping("dept/queryAll")
    public List queryAll();
    @GetMapping("dept/add")
    public boolean addDept(Dept dept);

}
