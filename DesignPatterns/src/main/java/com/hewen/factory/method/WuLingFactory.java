package com.hewen.factory.method;

/**
 * 2021/10/1
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class WuLingFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new WuLing();
    }
}
