package com.hewen.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 2022/1/25
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread().start();//怎么启动callable呢？
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        new Thread(new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        })).start();
        MyThread thread = new MyThread();
        //需要有一个适配类
        FutureTask<Integer> futureTask = new FutureTask<>(thread);
//        new Thread(new FutureTask<>(thread),"A").start();
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        //探究原理！
        Integer integer = futureTask.get();//获取callable的返回结果。
        //但是get方法可能会造成阻塞，因此我们尽量把他放在最后，或者呢使用异步通信来处理
        System.out.println(integer);
    }
}
class MyThread implements Callable<Integer> {
    //泛型的参数等于方法的返回值
    @Override
    public Integer call() throws Exception {
        System.out.println("调用了call方法");
        return 1024;
    }
}