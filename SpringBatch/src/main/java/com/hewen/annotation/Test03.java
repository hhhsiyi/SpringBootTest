package com.hewen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 2021/12/23
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//自定义注解
public class Test03 {
    @MyAnnotation2(name = "何文",age = 18,schools = "西北大学")
    public void test3(){

    }
    @MyAnnotation3("1")
    public void test2(){

    }
}
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数：参数类型+参数名，default “”表示如果不写参数则默认为空
    //注解可以显示赋值参数值，如果没有默认值，我们就一定要给注解赋值
    String name() default "";
    int age() default 0;
    int id() default -1;//如果默认值为-1，代表不存在，indexOf如果找不到，返回值就是-1
    String[] schools() default {"清华","北大"};
}
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();//假如是value，就会默认不用输，假如写了name，就一定得显式指定
}