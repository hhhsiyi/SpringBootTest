package com.hewen.annotation;

import java.lang.annotation.*;

/**
 * 2021/12/23
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//测试元注解
public class Test02 {
    @MyAnnotation
    public void test(){

    }
}
//一个源文件只能有一个public修饰的类
//Target表示我们的注解可以用在哪些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})
//表示我们的注解在什么时候有效，运行时也有效是最高级的
@Retention(value = RetentionPolicy.RUNTIME)
@Documented //表示我们是否将注解生成在javaDoc中
@Inherited //子类可以继承父类的注解
@interface MyAnnotation{

}
