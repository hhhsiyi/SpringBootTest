package com.hewen.thread;

/**
 * 2021/12/21
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//测试生产者消费者模型--》利用缓冲区解决，管程法
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Productor(synContainer).start();
        new Consumer(synContainer).start();

    }
}

class Productor extends Thread {
    SynContainer container;

    Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了" + i + "只鸡");
            container.push(new Chicken(i));
        }
    }
}

class Consumer extends Thread {
    SynContainer container;

    Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了" + container.pop().id + "只鸡");
        }
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer {
    Chicken[] chickens = new Chicken[10];
    int count = 0;

    //缓冲区大小
    public synchronized void push(Chicken chicken) {
        //如果容器满了，就需要等待消费者消费，如果没满，我们就需要丢入
        if (count == chickens.length) {
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，就需要生产者丢入产品
        chickens[count++] = chicken;
        //可以通知消费者消费了
        this.notifyAll();
//        count++;
    }

    //这里注意一定要先--，
// 否则会有空指针或者数组下标越界的问题，
// 好好理一下逻辑，应该是要先--的，
// 因为生产是先++，
// 所以消费一定是先--才能消费到同一个count的数据，
    public synchronized Chicken pop() {
        //判断能否消费
        if (count <= 0) {
            //等待生产者生成
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("要消费第"+count+"只鸡");
        Chicken chicken = chickens[--count];
        //count--;
        //他吃完了，就通知生产者生产
        this.notifyAll();
        return chicken;
    }
}