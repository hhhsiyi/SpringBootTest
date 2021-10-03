package com.hewen.factory.abstractFactory;

/**
 * 2021/10/1
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class MiPhone implements IphoneProduct{
    @Override
    public void start() {
        System.out.println("开小米");
    }

    @Override
    public void shutdown() {
        System.out.println("关小米");
    }

    @Override
    public void callup() {
        System.out.println("小米打");
    }

    @Override
    public void sendSMS() {
        System.out.println("小米发短信");
    }
}
