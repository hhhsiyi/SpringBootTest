package com.hewen;

/**
 * 2022/3/14
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class HewenHashMap {
    public static void main(String[] args) {
        HewenHashMap map = new HewenHashMap();
        map.put("hewen","19998");
    }
    public void put(String key, String value){
        System.out.println("key: "+key+"======hashCode: "+key+"\n"+"value: "+value+"\n存储位置:"+key);
//        new HashMap<>()
    }
}
