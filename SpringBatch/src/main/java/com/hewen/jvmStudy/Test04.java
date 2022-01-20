package com.hewen.jvmStudy;

/**
 * 2022/1/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Test04 {
    public static void main(String[] args) {
        long l = Runtime.getRuntime().maxMemory();//虚拟机试图使用的最大内存
        //单位：字节
        //1024*1024
        long l1 = Runtime.getRuntime().totalMemory();//返回JVM初始化的总内存
        System.out.println("最大内存"+(l/(double)1024/1024));
        System.out.println("总内存"+(l1/(double)1024/1024));
//        最大内存3928.0
//总内存246.0
        //电脑16g，最大4g，四分之一
        //jvm初始化内存约等于电脑内存的六十四分之一
        //默认情况下，分配的总内存是四分之一，初始化的内存为1/64


    }
}
