package com.hewen.jvmStudy;

/**
 * 2022/1/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Test02 {
    public static void main(String[] args) {
        new Test02().test();
    }
    public void test(){
        a();
    }
    public void a(){
        test();
    }
}
