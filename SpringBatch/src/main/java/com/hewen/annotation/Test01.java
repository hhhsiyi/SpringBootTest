package com.hewen.annotation;

import java.util.ArrayList;
import java.util.List;

public class Test01 extends Object{
    //什么是注解

    @Override //重写
    public String toString() {
        return super.toString();
    }
    public void testA(){

    }
    @Deprecated
    public static void testt(){
        System.out.println("收拾收拾");
    }
    @SuppressWarnings("all")
    public static void test02(){
        List objects = new ArrayList<>();
    }
    public static void main(String[] args) {
        testt();
    }
}
