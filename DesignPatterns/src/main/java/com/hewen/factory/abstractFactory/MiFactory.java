package com.hewen.factory.abstractFactory;

/**
 * 2021/10/1
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class MiFactory implements IProductFactory{
    @Override
    public IphoneProduct phoneProduct() {
        System.out.println("====MI====");
        return new MiPhone();
    }

    @Override
    public IRouterProduct RouterProduct() {
        System.out.println("====MI====");
        return new MiRouter();
    }
}
