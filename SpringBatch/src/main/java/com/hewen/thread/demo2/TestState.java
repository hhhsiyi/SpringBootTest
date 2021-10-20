package com.hewen.thread.demo2;

/**
 * 2021/10/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestState {
    //观察测试线程的状态
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("==========");
            }
        }  );
        Thread.State state = thread.getState();
        System.out.println(state);//New
        thread.start();//启动线程
        state = thread.getState();
        System.out.println(state);//Runnable
        while (state!=Thread.State.TERMINATED){
            //只要线程不终止
            Thread.sleep(100);
            state=thread.getState();
            System.out.println(state);//输出状态
        }
        thread.start();//这里会报错，因为死亡的线程无法再次启动了，相当于诈尸

    }
}
