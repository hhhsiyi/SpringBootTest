package com.hewen.thread.demo2;

/**
 * 2021/10/19
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestStop implements Runnable{
    //1设置一个标志位
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0 ;
        while (flag){
            System.out.println("run  ..... "+i++);
        }
    }

    public void stop(){
        this.flag=false;
    }
    //2设置一个公开的方法停止线程
    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 920; i++) {
            System.out.println("main  ..... "+i);
            if (i==900){
                testStop.stop();
                System.out.println("线程该停止了");
            }
        }

    }
}
