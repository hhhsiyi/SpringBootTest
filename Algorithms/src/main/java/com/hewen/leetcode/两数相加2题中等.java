package com.hewen.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 2021/10/13
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 两数相加2题中等 {
    @Test
    public void test01() {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(-4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next=listNode4;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        //listNode4.next=listNode2;
        ListNode x = addTwoNumbers(listNode1, listNode4);
        System.out.println(x);
        System.out.println("==========");
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        double listVal1 = getListVal(l1);
        double listVal2 = getListVal(l2);
        double v = listVal1 + listVal2;
        int i = new Double(v).intValue();
        System.out.println(i);
        int i1 = i / 10;
        int i2 = 0;
        while (i1 != 0) {
            i2 = i1 % 10;
            if (head == null) {
                head = tail = new ListNode(i2);
            } else {
                tail.next = new ListNode(i2);
                tail = tail.next;
            }
            i1 = i / 10;
        }
        return new ListNode(1);
    }

    public double getListVal(ListNode target) {
        Stack<Integer> integers = new Stack<>();
        double t = 0;
        while (target != null) {
            integers.push(target.val);
            target = target.next;
        }
        int i = 0;
        double pow;
        while (!integers.empty()) {
            pow = Math.pow(10, i);
            t = t + integers.pop() * pow;
            i++;
        }
        return t;
    }
}
