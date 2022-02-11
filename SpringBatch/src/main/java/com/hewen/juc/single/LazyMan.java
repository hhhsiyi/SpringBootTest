package com.hewen.juc.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 2022/2/9
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class LazyMan {
    private static boolean hewen = false;
    //懒汉式
    private LazyMan() {
        synchronized (LazyMan.class){
            if (hewen==false){
                hewen=true;
            } else {
                throw new RuntimeException("不要试图用反射破坏异常");
            }
            if (lazyMan!=null){
                throw new RuntimeException("不要试图用反射破坏异常");
            }
            //到这一步，其实已经是三重检测锁了。
        }
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
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                lazyMan.getInstance();
//            }).start();
//        }
//    }


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        //获得空参构造
        declaredConstructor.setAccessible(true);//无视构造器的私有属性
        LazyMan instance2 = declaredConstructor.newInstance();
        Field hewen = LazyMan.class.getDeclaredField("hewen");
        hewen.setAccessible(true);
        hewen.set(instance2,false);//给他改回来，那这样还是可以破坏懒汉单例的！
        LazyMan instance = declaredConstructor.newInstance();//这下第二个也是用反射来new的！
        System.out.println(instance+"    "+instance2);
    }

}
