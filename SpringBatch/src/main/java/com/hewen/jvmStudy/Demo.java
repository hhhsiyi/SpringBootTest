package com.hewen.jvmStudy;

/**
 * ClassName Demo
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/1/19 22:01
 */
public class Demo {
    public static void main(String[] args) {
        new Thread(()->{},"hewen").start();
    }
    //本地方法接口JNI
    //native：凡是带了native关键字的方法，说明java的作用范围就拿不到了，回去调用底层C语言的库
    //会进入本地方法栈，调用本地方法接口JNI java native interface
    //JNI的作用：拓展java的使用，融合不同的编程语言为Java所用！最初：C、C++
    //Java诞生的时候，C和C++横行，想要立足，必须要有调用C、C++的程序
    //他在内存区域中专门开辟了一块标记区域(native method stack)本地方法栈，！登记native方法
    //注意是登记
    //在最终执行的时候，加载本地方法库中的方法，通过JNI。
    //例如用Java程序驱动打印机、管理系统。
    private native void start0();
    //现在调用其他接口：Socket接口，WebService，Http
}
