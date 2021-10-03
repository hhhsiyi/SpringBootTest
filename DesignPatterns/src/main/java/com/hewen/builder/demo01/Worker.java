package com.hewen.builder.demo01;

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
        this.product = new Product();
    }

    @Override
    void buildA() {
        product.setBuildA("地基");
        System.out.println("地基");
    }

    @Override
    void buildB() {
product.setBuildB("钢筋");
        System.out.println("钢筋");
    }

    @Override
    void buildC() {
product.setBuildC("电线");
        System.out.println("电线");
    }

    @Override
    void buildD() {
product.setBuildD("粉刷");
        System.out.println("粉刷");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
