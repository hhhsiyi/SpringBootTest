package com.hewen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ClassName VueApplication
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/4/15 22:57
 */
@SpringBootApplication
//@ComponentScan({"com.hewen.controller","com.hewen.mapper"})
@MapperScan("com.hewen.mapper")
//@MapperScan("com.hewen.mapper.VueprojectDao")
public class VueApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(VueApplication.class,args);
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
}
