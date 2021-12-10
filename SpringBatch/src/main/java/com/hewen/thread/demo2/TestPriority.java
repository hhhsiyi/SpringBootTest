package com.hewen.thread.demo2;

import org.junit.Test;

/**
 * 2021/12/9
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestPriority {
    //测试线程优先级
    @Test
    public void test01(){
        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getName()+"---->>>主线程默认的优先级为"+Thread.currentThread().getPriority());
        Thread thread1 = new Thread(new MyPriority());
        Thread thread2 = new Thread(new MyPriority());
        Thread thread3 = new Thread(new MyPriority());
        Thread thread4 = new Thread(new MyPriority());
        Thread thread5 = new Thread(new MyPriority());
        Thread thread6 = new Thread(new MyPriority());
        thread1.start();
        thread2.setPriority(3);
        thread2.start();
        thread3.setPriority(4);
        thread3.start();
//        thread4.setPriority(11);
//        thread4.start();
        thread5.setPriority(Thread.MAX_PRIORITY);
        thread5.start();
//        thread6.setPriority(-1);
//        thread6.start();
    }


}
class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---->>>的优先级为"+Thread.currentThread().getPriority());


    }
}