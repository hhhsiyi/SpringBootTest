package com.hewen.bridge;

/**
 * 2022/3/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Test {
    public static void main(String[] args) {
        //苹果笔记本
        //联想台式机
        Computer computer = new Laptop(new Lenovo());
        computer.info();
    }
}
