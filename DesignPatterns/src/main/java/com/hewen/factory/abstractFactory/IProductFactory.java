package com.hewen.factory.abstractFactory;

/**
 * 2021/10/1
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//抽象产品工厂
public interface IProductFactory {
//生产手机
    IphoneProduct phoneProduct();

    IRouterProduct RouterProduct();

}
