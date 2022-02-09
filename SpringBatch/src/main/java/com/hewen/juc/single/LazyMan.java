package com.hewen.juc.single;

/**
 * 2022/2/9
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class LazyMan {
    //懒汉式
    private LazyMan() {
        System.out.println(Thread.currentThread().getName() + "  --OK");
    }

    ;

    private volatile static LazyMan lazyMan;

    public static LazyMan getInstance() {
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan == null) {
                    lazyMan = new LazyMan();//不是一个原子性操作！极端条件下会出现问题
                    /*
                    1.分配内存空间
                    2.执行构造方法
                    3.把这个对象指向这个空间
                    ！就有可能出现指令重排
                    123
                    132 A
                        B//此时，lazyMan还没有完成构造，就有可能出现空指针，
                     */
                }
            }
        }
        //双重检测锁，DCL懒汉式，
        return lazyMan;
    }

    //多线程并发。
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lazyMan.getInstance();
            }).start();
        }
    }
}
