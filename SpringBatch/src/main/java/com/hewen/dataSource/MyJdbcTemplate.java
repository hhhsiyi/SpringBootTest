package com.hewen.dataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;

/**
 * 2021/7/7
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class MyJdbcTemplate {
    @Bean
    public JdbcTemplate jdbcTemplate1(@Qualifier("myDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
