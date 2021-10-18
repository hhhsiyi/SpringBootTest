package com.hewen.leetcode;

/**
 * 2021/10/13
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    int size;
    Node head;
    public MyLinkedList() {
        this.size=0;
        this.head=null;
    }

//    public int get(int index) {
//
//    }

    public void addAtHead(int val) {
        this.size++;
        Node node = new Node(val);
        node.next=this.head;
        this.head=node;
    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
}
