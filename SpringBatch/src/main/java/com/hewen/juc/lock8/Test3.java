package com.hewen.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 2022/1/24
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Test3 {
    public static void main(String[] args) {
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();
        new Thread(()->{phone1.sendsms();},"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        new Thread(()->{phone.hello();},"B").start();
        //1.标准情况下，两个线程谁先打印！
        //先发短信，再打电话，是固定的
        //主线程sleep时，只开了第一个线程
        //2.sendsms延迟3s时，两个线程谁先打印
        //先发短信后打电话
        //为什么会这样呢？因为我们有synchronized锁，两个方法都加了synchronized锁
        //而这个锁的对象是方法的调用者！
        //而我们只有一个phone对象，所以是谁先拿到这把锁，谁就先执行！
        //3.增加了一个普通的公共方法，hello
        //正常情况下，先hello，因为他不是同步方法，不受锁的影响啊
        //4.将phone对象从一个加倍成两个。
        new Thread(()->{phone2.call();},"B").start();
        //5.增加两个静态的同步方法！
        //6.两个对象增加两个静态的同步方法跟4不一样的结果！
        //6这种情况，因为是锁了Class类模板，而类模板全局是唯一的，，因此就是一把锁！
        // 而3、4这些锁的是对象！
    }
}
class Phone3{
    //TODO 增加了两个静态的同步方法！
    //为什么会这样呢？因为我们有synchronized锁
    //static是静态方法，类一加载就有了！，他是个Class模板，
    // 这里锁的是class，是类，此时这个Phone3类是全局唯一的！
    public static synchronized void sendsms(){
//        System.out.println("发短信");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发完短信了");
    }

    public static synchronized void call(){
        System.out.println("call");
    }
}
