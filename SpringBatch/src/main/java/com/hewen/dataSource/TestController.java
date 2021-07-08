package com.hewen.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2021/7/7
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@RestController
public class TestController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //    @Test
    @RequestMapping("mytest")
    public void test(){
        jdbcTemplate.execute("select 1 from dual");
        System.out.println(1);
    }
}
