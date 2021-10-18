package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/9
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 排序链表148题 {
    @Test
    public void test1() {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(1);
        n2.next = n3;
        ListNode n4 = new ListNode(3);
        n3.next = n4;
        System.out.println(n1);
        ListNode listNode = sortList(n1);
        System.out.println(listNode);
        System.out.println(n1);

    }

    public ListNode sortList(ListNode head) {
//        HashSet<Integer> integers = new HashSet<>();
//        if (head.next!=null){
//            sortList(head,null);
//        }
//        return new ListNode();
        return sortList(head,null);
    }
    public ListNode sortList(ListNode head,ListNode tail) {
        if (head==null)
            return head;
        if (head.next==tail){
            head.next=null;
            return head;
        }
        //快慢指针找中间值
        ListNode slow = head, fast = head;
        while (fast!=tail){
            slow=slow.next;
            fast=fast.next;
            if (fast!=tail){
                fast=fast.next;
            }
        }//执行完这些就已经找到中间值了
        ListNode midNode = slow;
        ListNode list1 = sortList(head,midNode);
        ListNode list2 = sortList(midNode,tail);
//        ListNode sorted = merge(list1,list2);
        return merge(list1,list2);
    }
// 合并两个链表
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode resultList = new ListNode();
        ListNode prev = resultList;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev=prev.next;
        }
        if (list1!=null){
            prev.next=list1;
        }
        else if (list2!=null){
            prev.next=list2;
        }
        return resultList.next;
    }
}
