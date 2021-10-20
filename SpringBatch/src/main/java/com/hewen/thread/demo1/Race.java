package com.hewen.thread.demo1;

/**
 * 2021/10/19
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Race implements Runnable {

    public static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            //判断比赛是否结束
            boolean flag = gameOver(i);
            if (flag)
                break;
            if (Thread.currentThread().getName()=="兔子") {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "---跑了 " + i + " 步");
        }
    }

    private boolean gameOver(int steps) {
        //判断是否有胜利者
        if (winner != null) {
            return true;
        }
        if (steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("Winner is " + winner);
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
