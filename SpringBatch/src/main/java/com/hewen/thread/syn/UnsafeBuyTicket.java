package com.hewen.thread.syn;

/**
 * 2021/12/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class UnsafeBuyTicket {
    //不安全的买票
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"我的苦逼").start();
        new Thread(buyTicket,"废物").start();
        new Thread(buyTicket,"黄牛").start();

    }
}

class BuyTicket implements Runnable {

    private int ticketNum = 10;
    boolean flag = true;//外部停止方式

    @Override
    public void run() {
        //买票
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void buy() throws InterruptedException {
        if (ticketNum <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(100);
        //买
        System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNum);
        ticketNum--;
    }
}
