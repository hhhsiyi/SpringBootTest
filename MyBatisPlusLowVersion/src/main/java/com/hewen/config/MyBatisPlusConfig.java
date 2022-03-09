package com.hewen.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 2022/3/8
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Configuration//配置类
@MapperScan("com.hewen.mapper")
@EnableTransactionManagement//自动管理事务
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInnerInterceptor() {
        PaginationInterceptor paginationInnerInterceptor = new PaginationInterceptor();
        return paginationInnerInterceptor;
    }

//    @Bean
//    public MybatisPlusInterceptor logicSqlInjector() {
//        //高版本不需要注册这个逻辑删除组件，只需要加注解就行了
//        new LogicSql
//        interceptor.addInnerInterceptor(paginationInnerInterceptor);
//        return interceptor;
//    }

    //性能分析插件，在MP3.2以上版本就被废弃掉了
//    @Bean
//    @Profile({"dev","test"})
//    //测试环境开启，保证我们的效率
//    public MybatisPlusInterceptor performanceInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        return new PerformanceInterceptor();
//    }
}
