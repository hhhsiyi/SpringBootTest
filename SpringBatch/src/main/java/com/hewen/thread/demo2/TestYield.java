package com.hewen.thread.demo2;

/**
 * 2021/10/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestYield {
    //测试礼让线程，不一定成功，看CPU心情
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();

    }
}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
//        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}
