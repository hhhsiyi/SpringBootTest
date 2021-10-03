package com.hewen.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 2021/9/23
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//懒汉式单例

public class LazyMan {
    private static boolean hewen = false;//这个东西可以理解为红绿灯

    //构造器私有
    private LazyMan() {
        //  System.out.println(Thread.currentThread().getName() + "  OK");
        //升级版三重校验添加标志
        synchronized (LazyMan.class){
            if (hewen == false) {
                hewen = true;
            } else {
                throw new RuntimeException("不要试图不去创建对象就用反射破坏单例1");
            }
        }
        //三重校验被破坏
//        synchronized (LazyMan.class) {
//            if (lazyMan != null) {
//                throw new RuntimeException("不要试图用反射破坏单例");
//            }
//        }
    }

    //    private static LazyMan lazyMan;
    private volatile static LazyMan lazyMan;//防止指令重排序

    public static LazyMan getInstance() {
        //单线程下lazyManOK，但是多线程下就不一定了，数量不一定了，因此我们要加锁
        //双重检测锁模式的懒汉式单例，简称DCL懒汉式
        if (lazyMan == null) {
            synchronized (LazyMan.class) {//同步锁
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                    //这句不是一个原子性操作
                    //因此可能会执行：(可能会乱序)
                    //1.分配内存空间
                    //2.执行构造方法，初始化对象
                    //3.把这个对象指向这个空间
                    //真实的执行顺序可能是：
                    // 123
                    // 132 A
                    //     B
                    //假如A走成了132，再来一个B的时候，
                    //此时A是没问题的，B认为A已经走完了构造，就直接return了，
                    //但此时lazyMan还没有完成构造，B就会指向一片空指针虚无
                    //为了应对这个问题，在前端volatile 避免指令重排
                }
            }
        }
        //以上为加锁之后
//        if (lazyMan == null) {
//            lazyMan = new LazyMan();
//        }
        return lazyMan;
    }

    //    //测试高并发
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                LazyMan.getInstance();
//            }).start();
//        }
//    }
    //利用反射
    public static void main(String[] args) throws Exception {
        //加了红绿灯，我们依然要破坏怎么办呢
        Field hewen = LazyMan.class.getDeclaredField("hewen");
        hewen.setAccessible(true);//破坏私有权限

//        LazyMan instance = LazyMan.getInstance();
        //之所以注掉上面的，是为了破坏有非空校验的三重锁
//这个方法会返回参数类型的所有构造器，包括public的和非public的，当然也包括private的。
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);//暴力反射公有
        LazyMan instance = declaredConstructor.newInstance();
        hewen.set(instance,false);//通过改标志位破坏单例
        LazyMan instance2 = declaredConstructor.newInstance();//新改的
        System.out.println(instance);
        System.out.println(instance2);
        //输出的对象已经是不一样的了，说明反射已经破坏单例了
        //假如我们抛出异常，就不会有问题了
        //假如我们不走getInstance方法，就又会破坏单例。
    }

//    @Test
//    public void test测试高并发() {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                LazyMan.getInstance();
//            }).start();
//        }
//    }
}
