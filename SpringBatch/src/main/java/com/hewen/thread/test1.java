package com.hewen.thread;

/**
 * 2021/12/21
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class test1 {
    public static void main(String[] args) {
        Hewen hewen1 = null;
//        if (hewen1==null){
//            Hewen hewen = new Hewen("h", 23);
//            hewen1=hewen;
//        }
        hh(hewen1);
        System.out.println(hewen1);
    }
    public static Hewen hh(Hewen hewen1){
        if (hewen1==null){
            Hewen hewen = new Hewen("h", 23);
            hewen1=hewen;
        }
        return hewen1;
    }
}
