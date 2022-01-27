package com.hewen.juc.forkjoin;

import org.junit.Test;

import java.util.concurrent.RecursiveTask;

/**
 * 2022/1/27
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//3000普通、6000forkJoin、9000并行流Stream
public class ForkJoinDemo extends RecursiveTask<Long> {
    private long start;
    private long end;
    private long temp=10L;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }
//如何使用forkjoin：
// 1.执行forkJoinPool，
// 2.计算任务：forkJoinTask，
// 3.RecursiveAction递归事件(无返回值、RecursiveTask递归任务(有返回值
    @Test
    public void Test01(){
        if (end-start>temp) {
            //走分支合并计算
            int sum = 0;
            for (int i = 0; i < 1_0000_0000; i++) {
                sum+=i;
            }
            System.out.println(sum);
        } else {
            int sum = 0;
            for (int i = 0; i < 1_0000_0000; i++) {
                sum+=i;
            }
            System.out.println(sum);
        }
    }
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 1_0000_0000; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }
    //计算方法！
    @Override
    protected Long compute() {
        if (end-start>temp) {
            //走分支合并计算
            long sum = 0;
            for (long i = start; i < end; i++) {
                sum+=i;
            }
            System.out.println(sum);
            return sum;
        } else {
            long mid = (end+start)/2;
            ForkJoinDemo t1 = new ForkJoinDemo(start, mid);
            t1.fork();//拆分任务，把任务压入线程队列。
            ForkJoinDemo t2 = new ForkJoinDemo(mid+1, end);
            t2.fork();
            //走完了拆分。
            long res = t1.join() + t2.join();
            return res;
        }
    }
}
