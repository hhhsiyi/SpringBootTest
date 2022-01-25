package com.hewen.juc.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 2022/1/25
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class SemapHoreDemo {
    public static void main(String[] args) {
        //抢车位了
        Semaphore semaphore = new Semaphore(3);
        //默认管程数量---就是假设停车位
        //让他们在有限的时间内保持一定的顺序，限流的时候可以用到这个方法，流量入口只有这么大！！！
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
//                semaphore.acquire();//得到！
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到了车位");
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println(Thread.currentThread().getName() + "离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();//释放！
                }
            }).start();
        }
    }
}
