package com.hewen.builder.demo01;

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
        //指挥者
        Director director = new Director();
        //指挥工人按照顺序建造产品
        Product build = director.build(new Worker());
        System.out.println(build.toString());
    }
}
