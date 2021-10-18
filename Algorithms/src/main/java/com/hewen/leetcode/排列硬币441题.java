package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 排列硬币441题 {
    @Test
    public void test01() {
        System.out.println(arrangeCoins(9));
    }

    public int arrangeCoins(int n) {
        if (n==1){
            return 1;
        }
        int i=0;
        int temp=1;
        while (n-temp>=0){
            i++;
            n-=temp;
            temp++;
        }
        return i;
//        int A = 1;
//        int ret = 1;
//        if (n == 1) {
//            return ret;
//        }
//        while (n - (A + A + 1) >= 0) {
//            ret++;
//            n=n-A-A-1;
//            //A++;
//        }
//        return ret;

    }
}
