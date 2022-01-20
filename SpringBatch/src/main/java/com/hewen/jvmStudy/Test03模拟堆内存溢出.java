package com.hewen.jvmStudy;

import java.util.ArrayList;

/**
 * 2022/1/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Test03模拟堆内存溢出 {
    public static void main(String[] args) {
        byte[] myArrays = new byte[1 * 1024 * 1024];
        ArrayList<Object> objects = new ArrayList<>();
        while (true) {
            objects.add(myArrays);
        }
//        String a = "aaaa";
//        while (true) {
//            a += new Random().nextInt(888888888)+new Random().nextInt(2222222);
//        }
    }
}
