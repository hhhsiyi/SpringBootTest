package com.hewen.builder.demo02;


/**
 * 2021/10/3
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//抽象的
public abstract class Builder {
    abstract Builder buildA(String s);//汉堡
    abstract Builder buildB(String s);//可乐
    abstract Builder buildC(String s);//薯条
    abstract Builder buildD(String s);//甜点
    abstract Product getProduct();//得到产品
}
