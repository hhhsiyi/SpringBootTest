package com.hewen.juc;

/**
 * ClassName Test01
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/1/23 16:22
 */
public class Test01 {
    public static void main(String[] args) {
//        new Thread().start();
        //获取cpu核数
        //CPU密集型；IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
