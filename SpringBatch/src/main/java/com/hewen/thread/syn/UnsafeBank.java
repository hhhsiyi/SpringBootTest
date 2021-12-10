package com.hewen.thread.syn;

/**
 * 2021/12/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class UnsafeBank {
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
    public Drawing(Account account,int drawingMoney,int nowMoney){
        this.account=account;
        this.drawingMoney=drawingMoney;
        this.nowMoney=nowMoney;
    }

    @Override
    public void run() {
        if (account.money-drawingMoney<0){
            //钱不够
            System.out.println(Thread.currentThread().getName()+"钱不够，退出哦");
            return;
        }
        //余额=余额-取钱数
        account.money= account.money-drawingMoney;

        System.out.println("剩了这么多"+account.money);
//        System.out.println(Thread.currentThread().getName());
        System.out.println(this.getName()+"手里的钱："+nowMoney);
    }
}
