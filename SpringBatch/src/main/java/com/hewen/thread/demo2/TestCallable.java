package com.hewen.thread.demo2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 2021/10/19
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestCallable implements Callable<Boolean> {
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

    public TestCallable(String url, String name) {
        this.name = name;
        this.url = url;
    }
    //下载图片线程的执行体
    @Override
    public Boolean call() {
        TestCallable.WebDownLoader webDownLoader = new TestCallable.WebDownLoader();

        webDownLoader.downloader(url,name);

        System.out.println("下载的文件名字为"+name);

        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String t = "https://img-blog.csdnimg.cn/2019022515554319.png";
        String n = "美女";
//        默认下载的文件在项目的根路径下
        TestCallable testThread1 = new TestCallable(t,n+1+".png");
        TestCallable testThread2 = new TestCallable(t,n+2+".png");
        TestCallable testThread3 = new TestCallable(t,n+3+".png");
        //创建执行服务(类似于池子)
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = ser.submit(testThread1);
        Future<Boolean> r2 = ser.submit(testThread2);
        Future<Boolean> r3 = ser.submit(testThread3);
        //获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        //关闭服务
        ser.shutdownNow();


    }
}
