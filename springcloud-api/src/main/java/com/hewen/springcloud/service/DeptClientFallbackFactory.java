package com.hewen.springcloud.service;

import com.hewen.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 2021/11/22
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Component
public class DeptClientFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public Dept queryById(long id) {
                return new Dept().setDeptno(id).
                        setDname("这个id不存在:" + id + "  被客户端降级，这个服务现在被关闭了@hystrix").
                        setDb_source("no database");
            }

            @Override
            public List queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
