package com.hewen.thread.demo2;

/**
 * 2021/12/9
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestDaemon {
    //守护线程
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread tgod = new Thread(god);
        tgod.setDaemon(true);//默认false，表示用户线程，true是守护线程
        tgod.start();
        new Thread(you).start();//你出生了，用户线程，
    }
}
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑着你");
        }
    }
}
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println("活的很开心");
        }
        System.out.println("你完了！你完了！");
    }
}
