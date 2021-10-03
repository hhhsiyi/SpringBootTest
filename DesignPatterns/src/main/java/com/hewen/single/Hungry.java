package com.hewen.single;

/**
 * 2021/9/23
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//恶汉式单例
public class Hungry {
    //很饿，一上来就会接受不管三七二十一先new一个对象出来
//    不管三七二十一就创建对象，类名点就能用，假如创建了四个数组，那一上来就占了很大内存空间
    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];
    private byte[] data4 = new byte[1024*1024];

    public Hungry() {
    }
//  会不会浪费内存
    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance() {
        return HUNGRY;
    }
}
