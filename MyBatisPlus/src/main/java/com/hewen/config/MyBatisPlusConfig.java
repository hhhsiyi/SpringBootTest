package com.hewen.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
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

    //    注册乐观锁插件
//    @Bean
//    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor(){
//        return new OptimisticLockerInnerInterceptor();
//    }
    @Bean
    public MybatisPlusInterceptor optimisticLockerInnerInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

    @Bean
    public MybatisPlusInterceptor paginationInnerInterceptor() {
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.H2);
        //设置请求的页面大于最大页后操作，true调回到首页，false继续请求，默认false
        //paginationInnerInterceptor.setOverflow(false);
        //设置单页最大请求，默认500条， -1，不受限制
//        paginationInnerInterceptor.setMaxLimit(500L);
        //开启count的join优化，只针对部分left join (好像没了)
//        paginationInnerInterceptor.set
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
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
