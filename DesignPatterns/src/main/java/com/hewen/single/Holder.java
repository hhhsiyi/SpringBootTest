package com.hewen.single;

/**
 * 2021/9/23
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//静态内部类
    //也不安全
public class Holder {
    private Holder(){
    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }
    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}
