package com.hewen.thread.demo2;

import com.hewen.thread.demo1.TestThread4;

/**
 * 2021/10/19
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestSleep implements Runnable{
    private int ticketNums = 10;

    @Override
    public void run() {
        //多个线程操作同一个资源的时候，资源会紊乱
        while (true){
            if (ticketNums<=0){
                break;
            }
            System.out.println(Thread.currentThread()+"拿到了第   "+ticketNums--+"   张票");
            //模拟延时
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread1 = new TestThread4();
        new Thread(testThread1,"黄牛党").start();
        new Thread(testThread1,"路淑妍").start();
        new Thread(testThread1,"何文").start();
    }
}
