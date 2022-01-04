package com.hewen;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * ClassName Lottery
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/1/4 19:41
 */
//抽奖，中奖，完整的抽奖
public class Lottery {
    static String[] user = {
            "013400","013449"
    };
    static int num = 2;//多少人获奖

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        for(;;){
            if (set.size()==num){
                break;
            }
            int i = new SecureRandom().nextInt(user.length);
            set.add(user[i]);
        }
        Iterator<String> iterator = set.iterator();
        System.out.println("开奖公示");
        while (iterator.hasNext()){
            System.out.printf("中奖的是：%s\r\n",iterator.next());
        }
        System.out.println("恭喜");
    }
}
