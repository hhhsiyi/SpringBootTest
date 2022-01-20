package com.hewen.leetcode;

import java.util.List;

/**
 * 2022/1/18
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 最小时间差539题中等 {
    public int findMinDifference(List<String> timePoints) {
        return 1;
    }

    public static void main(String[] args) {

        String a = "15";
        int i = (a.charAt(0) - '0') * 10+ (a.charAt(1) - '0') * 60;
        System.out.println(i);
        System.out.println(getMinutes("15:30"));
    }
    public static int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }

}
