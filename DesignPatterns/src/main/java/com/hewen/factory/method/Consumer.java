package com.hewen.factory.method;

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
        Car car = new WuLingFactory().getCar();
        car.name();
        new TeslaFactory().getCar().name();
        new MoBaiFactory().getCar().name();
    }

//    @Test
//    public void test02(){
////        从工厂拿车出来
//        Car w = CarFactory.getCar("五菱");
//        w.name();
//        Car t = CarFactory.getCar("特斯拉");
//        t.name();
//
//    }
}
