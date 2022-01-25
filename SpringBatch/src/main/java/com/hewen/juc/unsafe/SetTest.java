package com.hewen.juc.unsafe;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 2022/1/25
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class SetTest {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        HashSet<Object> objects = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
        /**
         * 同理会发现也会报错java.util.ConcurrentModificationException
         * 解决方案：
         * 1.Set没有Vector这种顶替的办法，因此第一条是不可用的
         * 2.Collections转换成安全的Collections.synchronizedSet(new HashSet<>());
         * 3.CopyOnWriteArraySet
         */
    }
}
