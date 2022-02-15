package com.hewen.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2022/2/15
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 去掉最低工资和最高工资后的工资平均值1491题简单 {
    @Test
    public void test(){
        int[] a = {6000,5000,4000,3000,2000,1000};
        System.out.println(average(a));
    }
    public double average(int[] salary) {
        Arrays.sort(salary);
        double sum = Arrays.stream(salary).sum();
        sum=sum-salary[0]-salary[salary.length-1];
        return sum/(salary.length-2);
    }
}
