package com.hewen.juc.fucntion;

import java.util.function.Consumer;

/**
 * 2022/1/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Demo03 {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        };
        //打印字符串
        consumer.accept("dasd");
        Consumer<String> consumer1 = (a) -> {
            System.out.println(a);
        };
        consumer1.accept("何文");
    }
}
