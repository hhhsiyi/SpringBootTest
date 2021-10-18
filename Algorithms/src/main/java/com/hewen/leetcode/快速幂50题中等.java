package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/12
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 快速幂50题中等 {
    @Test
    public void test01(){
        double v = 2.00000;
        int n=-2;
        System.out.println(myPow(v,n));
    }

    public double myPow(double x, int n) {

        if (n>=0){
            return quickPow(x,n);
        }
        else {
            return 1/quickPow(x,-n);
        }
    }
    public double quickPow(double x,long n){
        if (n==0){
            return 1;
        }
        double v = quickPow(x, n / 2);
        if (n%2==0){
            return v*v;
        }else {
            return v*v*x;
        }
    }
}
