package com.hewen.juc.unsafe;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2022/1/25
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class MapTest {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>(16,0.75f);
//        Map<String, String> map = Collections.synchronizedMap(new HashMap<>(16,0.75f));
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 100; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
        /**
         * 2个解决方案，
         * Collections可以
         * ConcurrentHashMap
         */
    }
}
