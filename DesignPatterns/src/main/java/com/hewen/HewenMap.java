package com.hewen;

/**
 * 2022/3/14
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public interface HewenMap<K,V> {
    V put(K k,V v);
    V get(K k);
    int size();
    interface Entry<K,V>{
        K getKey();
        V getValue();
    }
}
