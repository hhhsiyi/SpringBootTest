package com.hewen.thread;

public class DeadLock {
    //模拟死锁:多个线程互相持有对方需要的资源，形成僵持
    public static void main(String[] args) {
        MakeUp makeUp1=new MakeUp(1,"lsy");
        MakeUp makeUp2=new MakeUp(0,"穆丽娜");
        makeUp1.start();
        makeUp2.start();
    }
}
class LipStick{

}
class Mirror{

}
class MakeUp extends Thread{
    static LipStick lipStick=new LipStick();
    static Mirror mirror=new Mirror();


    int choice;
    String girlName;//使用者
    MakeUp(int choice,String girlName){
        this.choice=choice;
        this.girlName=girlName;
    }
    @Override
    public void run() {
//        化妆
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeUp() throws InterruptedException {
        if (choice==0){
            synchronized (lipStick){
                //获得口红的锁
                System.out.println(this.girlName+"获得口红锁");
                Thread.sleep(1000);
                //一秒钟后想获得镜子
                synchronized (mirror){
                    System.out.println(this.girlName+"获得镜子锁");
                }
            }
        }else {
            synchronized (lipStick){
                //获得口红的锁
                System.out.println(this.girlName+"获得镜子锁");
                Thread.sleep(2000);
                //一秒钟后想获得镜子
                synchronized (mirror){
                    System.out.println(this.girlName+"获得口红锁");
                }
            }
        }
    }
}
