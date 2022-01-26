package com.hewen.juc.fucntion;

import java.util.function.Supplier;

/**
 * 2022/1/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Demo04 {
    //供给型接口
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "I m fine";
            }
        };
        System.out.println(supplier.get());
        Supplier<String> supplier1 = ()->{return "iiii";};
        System.out.println(supplier1.get());
    }
}
