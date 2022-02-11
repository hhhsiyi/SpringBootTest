package com.hewen.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 2022/2/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 无重复字符的最长子串3题中等 {
    @Test
    public void test01() {
//滑动窗口
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length()==1){
            return 1;
        }
//        if (s==" "){
//            return 1;
//        }
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            needs.put(c, needs.getOrDefault(c, 1));
        }
//        System.out.println(needs);
        int len = Integer.MIN_VALUE;
        int left = 0 ;
        int right = 0;
        Map<Character, Integer> windows = new HashMap<>();
        while (right < s.length()) {
            char d = s.charAt(right);
            windows.put(d, windows.getOrDefault(d, 0)+1);
            if (needs.containsKey(d)) {
                if (!windows.get(d).equals(needs.get(d))){
                    len = Math.max(len,right-left );
                    left++;
                    right=left;
                    windows=new HashMap<>();
                    continue;
                }
                if (windows.size()==s.length()){
                    return windows.size();
                }
            }
            right++;
            if (right==s.length()){
                len = Math.max(len,right-left );
            }
        }
        return len;
    }
}
