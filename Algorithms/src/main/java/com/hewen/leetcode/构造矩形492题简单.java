package com.hewen.leetcode;

import org.junit.Test;

public class 构造矩形492题简单 {
    @Test
    public void test01(){

        int a = 5;
        int[] ints = constructRectangle(a);
        for (int i :
                ints) {
            System.out.println(i);
        }
    }

    public int[] constructRectangle(int area) {
        double sqrt = Math.sqrt(area);
        int a = new Double(sqrt).intValue();
        while (area%a!=0){
            --a;
        }
        return new int[]{area/a,a};
    }
}
