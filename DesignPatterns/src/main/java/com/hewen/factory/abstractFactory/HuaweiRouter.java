package com.hewen.factory.abstractFactory;

/**
 * 2021/10/1
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class HuaweiRouter implements IRouterProduct{
    @Override
    public void start() {
        System.out.println("开华为");
    }

    @Override
    public void shutdown() {
        System.out.println("关华为");
    }

    @Override
    public void openWifi() {
        System.out.println("华为开wifi");
    }

    @Override
    public void setting() {
        System.out.println("华为设置");
    }
}
