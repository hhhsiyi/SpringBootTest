package com.hewen.juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * 2022/1/27
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
        test2();
        test3();
    }
    public static void test1(){
        Long start = System.currentTimeMillis();
        //普通程序员
        Long sum = 0L;
        for (Long i = 0L; i < 10_0000_0000; i++) {
            sum+=i;
        }
        Long end = System.currentTimeMillis();
        System.out.println("sum="+sum+ "时间"+(end-start));
    }
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0, 10_0000_0000);
        forkJoinPool.execute(task);//执行
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);//提交
        System.out.println(submit.get());
        long end = System.currentTimeMillis();
        System.out.println("sum="+submit.get()+ "时间"+(end-start));
    }
    public static void test3(){
//        Long sum = 0L;
        long start = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum="+ "时间"+(end-start));
    }
}
