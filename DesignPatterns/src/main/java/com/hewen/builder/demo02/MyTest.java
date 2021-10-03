package com.hewen.builder.demo02;


import org.junit.Test;

/**
 * 2021/10/3
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class MyTest {
    @Test
    public void test01() {
        Worker worker = new Worker();
        Product product = worker.buildA("美年达").getProduct();
        System.out.println(product);
    }
}
