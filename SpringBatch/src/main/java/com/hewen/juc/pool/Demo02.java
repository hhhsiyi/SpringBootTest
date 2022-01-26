package com.hewen.juc.pool;

import java.util.concurrent.*;

/**
 * 2022/1/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Demo02 {
    //手动创建线程池
    public static void main(String[] args) {
        //自定义线程池，工作中一定要这样。
//        List list = new ArrayList<>();
//        list.forEach();
        ExecutorService pool = new ThreadPoolExecutor(2,
                Runtime.getRuntime().availableProcessors(),
        3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());//银行满了还有人进来，abort就是不处理这个人了，抛出异常。。
//        new ThreadPoolExecutor.CallerRunsPolicy());//银行满了还有人进来，哪来的去哪里
//                new ThreadPoolExecutor.DiscardPolicy());//银行满了还有人进来，队列满了，就会丢掉任务，但是不会抛出异常
                new ThreadPoolExecutor.DiscardOldestPolicy());//队列满了，想去和最先来的那个人竞争，也不会抛出异常。没有空闲线程+队列满了 就会被抛弃

        try {
            for (int i = 1; i <= 9; i++) {
                //使用了线程池之后，用线程池来创建线程
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "  OK");
                });
            }
            //8的时候，我们的5个窗口才会全部开启！
            //最大承载数=Deque+max
            //9个的时候，会抛出异常
            // java.util.concurrent.RejectedExecutionException
            //Task com.hewen.juc.pool.
            // Demo02$$Lambda$14/0x0000000800066840@18be83e4
            // rejected from java.util.concurrent.ThreadPoolExecutor@cb5822
            // [Running, pool size = 5, active threads = 5, queued tasks = 3, completed tasks = 0]
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
