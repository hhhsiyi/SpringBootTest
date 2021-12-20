package com.hewen.thread.syn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 2021/12/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//线程不安全的list
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
        //为什么输出不是10000呢，因为线程不安全，在同一时间，大家操作了同一个内存地址的东西

    }
    @Test
    public void test01(){
        new HashMap<String,String>()
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
