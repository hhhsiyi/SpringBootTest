package com.hewen.juc.volatileTest;

import java.util.concurrent.TimeUnit;

/**
 * 2022/2/9
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class JMMDemo {
    private volatile static int num = 0;
    //不加volatile程序就不会停止，
    public static void main(String[] args) {
        //main线程
        new Thread(()->{
            while (num==0){
                //程序读了0之后，没有时间去获取新的值，因此他一直是0，线程hewen并没有拿到值！
                //因此，需要当前线程知道主内存中的值发生了变化。
            }
        },"hewen").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num=1;
        System.out.println(num);
    }
}
