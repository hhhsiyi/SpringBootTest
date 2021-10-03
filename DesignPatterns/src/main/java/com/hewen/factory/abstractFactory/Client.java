package com.hewen.factory.abstractFactory;

import org.junit.Test;

/**
 * 2021/10/1
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Client {
    @Test
    public void test01()    {
        IphoneProduct iphoneProduct = new MiFactory().phoneProduct();
        iphoneProduct.start();
        iphoneProduct.callup();
        iphoneProduct.sendSMS();
        iphoneProduct.shutdown();
        IRouterProduct iRouterProduct = new MiFactory().RouterProduct();
        iRouterProduct.openWifi();
        IRouterProduct iRouterProduct1 = new HuaweiFactory().RouterProduct();
        iRouterProduct1.openWifi();
    }
}
