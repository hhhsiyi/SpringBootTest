package com.hewen.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 2021/10/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 反转链表206题简单 {
    @Test
    public void test01() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(l1);
        System.out.println(reverseList(l1));
    }

    public ListNode reverseList(ListNode head) {
        ListNode currNode = new ListNode();
        ListNode resNode = new ListNode();
        Stack<Integer> integers = new Stack<>();
        while (head != null ) {
            integers.push(head.val);
            head=head.next;
        }
        resNode=currNode;
        while (!integers.empty()){
            currNode.next=new ListNode(integers.pop());
            currNode=currNode.next;
        }
        return resNode.next;
    }
}
