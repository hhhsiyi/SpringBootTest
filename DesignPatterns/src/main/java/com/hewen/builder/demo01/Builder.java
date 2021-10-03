package com.hewen.builder.demo01;

/**
 * 2021/10/3
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//抽象的
public abstract class Builder {
    abstract void buildA();//地基
    abstract void buildB();//钢筋
    abstract void buildC();//电线
    abstract void buildD();//粉刷
    abstract Product getProduct();//得到产品
}
