package com.hewen.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 2022/1/27
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 异步调用，就理解为服务端和客户端之间的ajax
         * 异步执行
         * 成功回调
         * 失败回调
         */
        //这个是没有返回值的异步回调
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "runAsync=>void");
//        });
//        //上面的
//        System.out.println("1111");//测试异步执行
//        completableFuture.get();//获得阻塞执行的结果。

        System.out.println("==========");
        //有返回值的异步回调，成功或者失败的回调
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "runAsync=>Integer");
            //测试错误的返回
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            int i = 1/0;
            return 1024;
        });
        System.out.println(completableFuture2.whenComplete((u1, u2) -> {
            System.out.println(u1 + "   " + u2);
        }).exceptionally((t) -> {
//            t.printStackTrace();
            System.out.println(t.getMessage());
            return 233;
        }).get());
        //ForkJoinPool.commonPool-worker-19runAsync=>Integer
        //1024   null
        //正常情况下是这个输出值
        //错误的情况下输出这个值，也就是说正常有正常的解读，异常有异常的解读。
        //ForkJoinPool.commonPool-worker-19runAsync=>Integer
        //null   java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
        //233
    }
}
