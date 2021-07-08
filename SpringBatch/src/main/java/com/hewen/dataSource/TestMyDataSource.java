package com.hewen.dataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * 2021/7/7
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestMyDataSource {
    @Autowired
    private MyDataSourceProperties dataSourceProperties;

    @Bean(name = "myDataSource")
    public DataSource dataSource(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername(dataSourceProperties.getUsername());
        hikariConfig.setJdbcUrl(dataSourceProperties.getJdbcUrl());
        hikariConfig.setPassword(dataSourceProperties.getPassword());
        hikariConfig.setDataSourceClassName(dataSourceProperties.getDriverclassname());
        HikariDataSource hikariDataSource = new HikariDataSource();
        return hikariDataSource;
    }
}
