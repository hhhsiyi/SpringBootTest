package com.hewen.juc.single;

/**
 * 2022/2/9
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Hungry {
    private byte[]data1 = new byte[1024*1024];
    private byte[]data2 = new byte[1024*1024];
    private byte[]data3 = new byte[1024*1024];
    private byte[]data4 = new byte[1024*1024];
//    饿汉式
    private Hungry(){};
    //构造器私有
    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }
}
