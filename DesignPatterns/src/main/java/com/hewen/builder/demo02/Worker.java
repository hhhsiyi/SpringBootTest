package com.hewen.builder.demo02;


/**
 * 2021/10/3
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//具体的建造者
public class Worker extends Builder {
private Product product;

    public Worker() {
        product=new Product();
    }

    @Override
    Builder buildA(String s) {
        product.setBuildA(s);
        return this;
    }

    @Override
    Builder buildB(String s) {
        product.setBuildB(s);
        return this;
    }

    @Override
    Builder buildC(String s) {
        product.setBuildC(s);
        return this;
    }

    @Override
    Builder buildD(String s) {
        product.setBuildD(s);
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}
