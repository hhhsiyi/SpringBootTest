package com.hewen.springcloud.config;

import com.hewen.springcloud.filter.MyLoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2021/12/8
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Configuration
public class DefineFilter {
    @Bean
    public MyLoginFilter myLoginFilter(){
        return new MyLoginFilter();
    }
}
