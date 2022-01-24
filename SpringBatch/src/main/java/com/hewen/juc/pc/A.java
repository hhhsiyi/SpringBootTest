package com.hewen.juc.pc;

/**
 * 2022/1/24
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//线程之间的通信问题：生产者消费者问题。等待唤醒机制，通知唤醒机制
    //线程交替执行， a、b操作同一个变量。 num=0
public class A {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
//判断等待、业务、通知
class Data{
    //资源类
    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        while (num!=0){
            //等待
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"->"+num);
        //通知
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        while (num==0){
            //等待
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"->"+num);
        //通知
        this.notifyAll();
    }
}