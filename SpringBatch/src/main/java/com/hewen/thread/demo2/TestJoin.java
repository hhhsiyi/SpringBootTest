package com.hewen.thread.demo2;

/**
 * 2021/10/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("vip来了，插队了插队了" + i);
        }
    }

    //插队
    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        //主线程还有方法呢
        for (int i = 0; i < 20; i++) {
            if (i == 12) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("插队来啦");
            }
            System.out.println("MAIN很闲靠边站了" + i);
        }
    }
}
