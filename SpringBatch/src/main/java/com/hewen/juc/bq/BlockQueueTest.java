package com.hewen.juc.bq;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 2022/1/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class BlockQueueTest {
    public static void main(String[] args) throws InterruptedException {
        //List、Set、BlockQueue不是新的东西
        //arrayBlockingQueue、LinkedBlockingQueue
        test4();
    }
    //1.抛出异常的
    public static void test1(){
        Queue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.add("a"));
        System.out.println(queue.add("b"));
        System.out.println(queue.add("c"));
//        System.out.println(queue.add("d"));
        //java.lang.IllegalStateException: Queue full
        System.out.println("========");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.element());
        System.out.println(queue.remove());
        //java.util.NoSuchElementException
//        System.out.println(queue.remove());
        //
    }
    //不抛异常
    public static void test2(){
        Queue<Object> q = new ArrayBlockingQueue<>(3);
        System.out.println(q.offer("a"));
        System.out.println(q.offer("b"));
        System.out.println(q.offer("c"));
        System.out.println(q.offer("d"));

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.poll());
        //null空值了
        //true
        //true
        //true
        //false
        //a
        //b
        //c
        //null
    }
    //3.阻塞 等待（一直阻塞）
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.put("a");
        queue.put("b");
        queue.put("c");
        //如果满了，来了新的，就会一直等
//        queue.put("d");
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());//没有这个元素
    }
    //4.等待 超时
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        //如果满了，来了新的，就会一直等
        queue.offer("d",2, TimeUnit.SECONDS);//假设前面是满的，我就2s后超时退出了
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll(2,TimeUnit.SECONDS));//没有这个元素
    }
}
