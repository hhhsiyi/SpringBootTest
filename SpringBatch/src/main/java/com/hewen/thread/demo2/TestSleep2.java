package com.hewen.thread.demo2;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2021/10/19
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestSleep2 implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01() {
        Date date = new Date(System.currentTimeMillis());
        while (true) {
            try {
                Thread.sleep(100);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
                date=new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true) {
            Thread.sleep(200);
            System.out.println(num--);
            if (num <= 0) {
                System.out.println("时间到");
                break;
            }
        }
    }
    @Test
    public void tesss01(){
char c = 74;

    long h = 999;
    String s = null;
    if ((s!=null)&&(s.length()>0)){
        System.out.println(1);
    }
    int _name;
    int first;
        if ((s==null)||(s.length()==0)){
            System.out.println(1);
        }
    }
}
