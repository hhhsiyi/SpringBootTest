package com.hewen.builder.demo01;

/**
 * 2021/10/3
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//指挥者
public class Director {
    //指挥工人按照顺序建造房子，到底想要什么顺序其实是你自己决定的哦
    public Product build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        return builder.getProduct();
    }
}
