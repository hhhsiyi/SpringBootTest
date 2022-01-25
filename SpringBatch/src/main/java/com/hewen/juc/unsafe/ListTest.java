package com.hewen.juc.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 2022/1/25
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        list.forEach(System.out::println);

        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(UUID.randomUUID().toString().substring(0,5));
        }
        list1.forEach(System.out::println);
        List<String> list2 = Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <= 100; i++) {
            new Thread(()->{
                list2.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list2);
            },String.valueOf(i)).start();
        }
        //并发下ArrayList不安全
        /**
         * 解决方案：
         * 1.ArrayList变成vector就安全了，为啥呢？自己去看源码，会发现，vector默认给我们加了Synchronized方法
         * 》》ArrayList是jdk1.2出来的
         * 》》vector是jdk1.0就出来的
         * 2.用集合的工具类Collections
         * List<String> list2 = Collections.synchronizedList(new ArrayList<>());
         * 给我们生成一个new Collections.SynchronizedRandomAccessList(list)
         * 3.CopyOnWriteArrayList
         * CopyOnWrite是什么呢？
         * 写入时复制
         * COW：计算机程序设计领域的一种优化策略
         * 多个线程调用时，list，读取的时候是固定的，写入的时候(覆盖)
         * 相当于在写入的时候，避免覆盖，造成数据问题。
         * 读写分离的思想
         * CopyOnWriteArrayList比Vector的厉害之处？
         * Vector有Synchronized方法，加锁效率会低下。
         * CopyOnWriteArrayList没有锁，用的Lock锁，但是jdk11又改成synchronize了，但是锁了对象
         */
        List<String> list3 = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 100; i++) {
            new Thread(()->{
                list3.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list3);
            },String.valueOf(i)).start();
        }
    }
}
