package com.hewen.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2022/2/14
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 找到字符串中所有字母异位词438题中等 {
    @Test
    public void test() {
        String s = "abb";
        String p = "bb";
        System.out.println(findAnagrams(s, p));
    }

    //滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            needs.put(p.charAt(i), needs.getOrDefault(p.charAt(i),0)+1);
        }
//        System.out.println(needs);
        int index = 0;
        while (index < s.length()) {
            windows.put(s.charAt(index),windows.getOrDefault(s.charAt(index), 0)+1);
            if (is(needs, windows)) {
                res.add(index-p.length()+1);
//                windows.remove(s.charAt(index-p.length()+1));
            }
            if (index>=needs.size()-1) {
                if (windows.get(s.charAt(index-p.length()+1))>1)
                    windows.put(s.charAt(index-p.length()+1),windows.get(s.charAt(index-p.length()+1))-1);
                else
                    windows.remove(s.charAt(index - p.length() + 1));
            }
            index++;
        }
        return res;
    }

    private boolean is(Map<Character, Integer> need, Map<Character, Integer> window) {
        int num = 0;
        for (Character c : need.keySet()) {
            if (window.get(c)==null){
                return false;
            }
            if (window.get(c) == need.get(c)) {
                num++;
            }
        }
        if (num == need.size())
            return true;
        else
            return false;
    }
}
