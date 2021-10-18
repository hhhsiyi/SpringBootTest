package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/15
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 外观数列38题中等 {
    @Test
    public void test01() {
        System.out.println(countAndSay2(2));
    }

    public String countAndSay(int n) {
        String str = "1";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        if (n == 1) {
            return stringBuilder.toString();
        } else {
            return getPre(countAndSay(n - 1));
        }
    }

    public String getPre(String last) {
        int t = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        while (t < last.length()) {
            while (t + 1 < last.length() && last.charAt(t + 1) == last.charAt(t)) {
                count++;
                t++;
            }
            stringBuilder.append(count).append(t);
            t++;
        }
        return stringBuilder.toString();
    }


    public String countAndSay2(int n) {
        // 递归法
        if (n == 1) return "1";

        // 上一个的结果
        String last = countAndSay(n - 1);

        // 计算本次的结果
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < last.length(); j++) {
            // 存储每个字符连续出现的次数
            int count = 1;
            while (j + 1 < last.length() && last.charAt(j + 1) == last.charAt(j)) {
                count++;
                j++;
            }
            sb.append(count).append(last.charAt(j));
        }

        return sb.toString();
    }

}
