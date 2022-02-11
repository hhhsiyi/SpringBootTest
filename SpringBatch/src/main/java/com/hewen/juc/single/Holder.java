package com.hewen.juc.single;

/**
 * 2022/2/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Holder {
    private Holder(){

    }
    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }
    //静态内部类实现
    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}
