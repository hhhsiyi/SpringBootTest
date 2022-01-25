package com.hewen.juc.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 2022/1/25
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //集齐7颗龙珠召唤神龙。
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤成功");
        });
        for (int i = 1; i <= 7; i++) {
            //lambda能拿到外层的i吗？不能。只能通过一个中间变量去中转，然后才能拿到这个值
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集了"+finalI+"颗龙珠");
                try {
                    cyclicBarrier.await();
                    //假如上面我写了8，而这里只有7，会导致程序死在这里！
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
