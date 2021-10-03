package com.hewen.factory.simple;

import org.junit.Test;

/**
 * 2021/10/1
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Consumer {
    @Test
    public void test01(){
        WuLing wuLing = new WuLing();
        Tesla tesla = new Tesla();
        wuLing.name();
        tesla.name();
    }
    @Test
    public void test02(){
//        从工厂拿车出来
        Car w = CarFactory.getCar("五菱");
        w.name();
        Car t = CarFactory.getCar("特斯拉");
        t.name();

    }
}
