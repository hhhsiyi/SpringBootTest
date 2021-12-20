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
                Thread.sleep(100);
                //只有让sleep睡在这里才算是真的
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 假如加了synchronized，这个方法就变成了同步方法，同步方法，锁的是什么，锁的是this
    private synchronized void buy() throws InterruptedException {
        if (ticketNum <= 0) {
            flag = false;
            return;
        }
//        Thread.sleep(500);//在同步方法里面sleep就像是抱着锁睡，一直是自己在占用着
        //买
        System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNum);
        ticketNum--;
    }
    /*
    加之前
    我的苦逼买到了第10
废物买到了第10
黄牛买到了第10
废物买到了第7
黄牛买到了第7
我的苦逼买到了第7
废物买到了第4
我的苦逼买到了第4
黄牛买到了第4
我的苦逼买到了第1
黄牛买到了第1
废物买到了第1
     */

    /*
    加了之后
我的苦逼买到了第10
我的苦逼买到了第9
我的苦逼买到了第8
我的苦逼买到了第7
我的苦逼买到了第6
我的苦逼买到了第5
我的苦逼买到了第4
我的苦逼买到了第3
我的苦逼买到了第2
我的苦逼买到了第1
     */
}
