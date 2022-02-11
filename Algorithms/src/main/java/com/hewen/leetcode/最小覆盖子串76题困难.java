package com.hewen.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * 2022/2/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 最小覆盖子串76题困难 {
    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();
    public String minWindow(String s, String t) {
        String res = "";
        if (s.length() < t.length())
            return res;
        //开始用双指针在s中寻找t的最小覆盖子串
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> windows = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i),0)+1);
        }
//        needs.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));
        int resLen = Integer.MAX_VALUE;
        int successNum = 0;
        int start = 0;
        //只要right不超过s的长度，就不停止查找
        while (right < s.length()) {
            char c = s.charAt(right);//当前右窗口遍历到的字符
            right++;
//            windows.put(s.charAt(right),null);
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c,0) + 1);
                if (windows.get(c).equals(needs.get(c))) {
                    successNum++;
                }
            }
            //窗口收缩
            while (successNum == needs.size()) {
                if (right - left < resLen) {
                    start = left;
                    resLen = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    if (windows.get(d).equals(needs.get(d))) {
                        successNum--;
                    }
                    windows.put(d, windows.getOrDefault(d,0) - 1);
                }
            }

        }
        return resLen == Integer.MAX_VALUE?"":s.substring(start,start+resLen);
    }

    @Test
    public void test01() {
        String s = "AA";
        String t = "AA";
        System.out.println(minWindow(s, t));

    }
}
