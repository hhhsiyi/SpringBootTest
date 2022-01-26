package com.hewen.juc.fucntion;

import java.util.function.Function;

/**
 * 2022/1/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Demo01 {
    public static void main(String[] args) {
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String o) {
                return o;
            }
        };
        //输出输入的值，函数式接口工具
        System.out.println(function.apply("123"));
        //函数式接口：有一个输入参数，有一个输出参数，函数式接口，就可以使用lambda表达式
        Function<String, String> function1 = (str)->{return str;};
        System.out.println(function1.apply("3"));
    }
}
