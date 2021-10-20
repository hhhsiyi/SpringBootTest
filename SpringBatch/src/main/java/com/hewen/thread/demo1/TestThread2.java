package com.hewen.thread.demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 2021/10/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestThread2 extends Thread {
    //练习多线程，网图下载，实现多线程同步下载图片
    class WebDownLoader {
        //下载方法
        public void downloader(String url, String name) {
            try {
                FileUtils.copyURLToFile(new URL(url), new File(name));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.name = name;
        this.url = url;
    }
    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();

        webDownLoader.downloader(url,name);

        System.out.println("下载的文件名字为"+name);
    }

    public static void main(String[] args) {
        String t = "https://img-blog.csdnimg.cn/2019022515554319.png";
        String n = "美女";
//        默认下载的文件在项目的根路径下
        TestThread2 testThread1 = new TestThread2(t,n+1+".png");
        TestThread2 testThread2 = new TestThread2(t,n+2+".png");
        TestThread2 testThread3 = new TestThread2(t,n+3+".png");
        testThread1.start();
        testThread2.start();
        testThread3.start();
    }
}

//重写run方法
