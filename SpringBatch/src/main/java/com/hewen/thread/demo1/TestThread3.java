package com.hewen.thread.demo1;

/**
 * 2021/10/19
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestThread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我sb"+i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        TestThread3 testThread3 = new TestThread3();
        //创建线程对象，通过线程对象来开启我们的线程代理
//    public Thread(Runnable target) {
//            this((ThreadGroup)null, target, "Thread-" + nextThreadNum(), 0L);
//        }
//        Thread thread = new Thread(testThread3);
//        thread.start();
        new Thread(testThread3).start();
        for (int i = 0; i < 200; i++) {
            System.out.println("我真的不是sb"+i);
        }
    }
}
