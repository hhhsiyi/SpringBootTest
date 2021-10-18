package com.hewen.thread.demo1;

/**
 * 2021/10/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestThread1 extends Thread {
    @Override
    public void run() {
        //super.run();
        for (int i = 0; i < 20; i++) {
            System.out.println("我是sb"+i);
        }
        //线程体
    }

    public static void main(String[] args) {
        //创建一个线程对象，调用start方法
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();//start方法，的顺序是乱的，乱就是对的，相当于开了一个新的子线程，所以是乱的
        //注意：线程开启不一定立即执行，由我们的cpu进行调度
        //testThread1.run();//run方法，干什么都是在当前线程里的，顺序是不会乱的，就是有先后顺序的
        //主线程
        for (int i = 0; i < 20; i++) {
            System.out.println("我真的不是sb"+i);
        }
    }
}

//重写run方法
