package com.hewen.thread.syn;

/**
 * 2021/12/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account cib = new Account(300, "CIB");

        Drawing h = new Drawing(cib, 30, "何文");
        Drawing l = new Drawing(cib, 100, "lsy");
        h.start();
        l.start();

    }
}

class Account{
    int money;//余额
    String name;//卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
class Drawing extends Thread {
    //模拟取款
    Account account;//账户
    int drawingMoney;//取多少钱
    int nowMoney;
    public Drawing(Account account,int drawingMoney,String threadName){
        super(threadName);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }
//synchronized默认 锁的是this，就是本身，这个时候用他并不是很好，因此引入了同步块监视器
    //锁的对象就是变化的量，也就是需要增删改的对象
    //哪个类的属性会发生变化，就锁哪个类的对象！
    @Override
    public  void run() {
//        try {
//            Thread.sleep(1000);
//            // sleep之后，就会放大线程的不安全的特性
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        synchronized (account){
            if (account.money-drawingMoney<0){
                //钱不够
                System.out.println(Thread.currentThread().getName()+"钱不够，退出哦");
                return;
            }
            try {
                Thread.sleep(1000);
                // sleep之后，就会放大线程的不安全的特性
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//余额=余额-取钱数
            System.out.println("此时余额为"+account.money);
            account.money= account.money-drawingMoney;
            nowMoney=nowMoney+drawingMoney;
            System.out.println("剩了这么多"+account.money);
//            System.out.println(Thread.currentThread().getName());
            System.out.println(this.getName()+"手里的钱："+nowMoney);
        }
        //下面的都是之前的不安全的银行账户
//        if (account.money-drawingMoney<0){
//            //钱不够
//            System.out.println(Thread.currentThread().getName()+"钱不够，退出哦");
//            return;
//        }
//        try {
//            Thread.sleep(1000);
//            // sleep之后，就会放大线程的不安全的特性
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //余额=余额-取钱数
//        account.money= account.money-drawingMoney;
//        nowMoney=nowMoney+drawingMoney;
//        System.out.println("剩了这么多"+account.money);
////        System.out.println(Thread.currentThread().getName());
//        System.out.println(this.getName()+"手里的钱："+nowMoney);
    }
}
