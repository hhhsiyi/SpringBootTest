package com.hewen.thread.staticProxy;

/**
 * 2021/10/19
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//静态代理模式总结：
//    真实对象和代理对象都实现同一个接口
//    代理对象要代理真实角色
//    好处：代理对象可以做很多真实对象做不了的事情，真实对象就专注做自己的事情
public class StaticProxy {
    public static void main(String[] args) {
//开启多线程了
//        new Thread(
//                new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                }
//        ).start();
        new Thread(()-> System.out.println("我不喜欢你了")).start();
        //对比一下感受一下两者区别
        new WeddingCompany(new You()).HappyMarry();
//        You you = new You();
//        WeddingCompany weddingCompany = new WeddingCompany(you);
//        weddingCompany.HappyMarry();
    }
}
