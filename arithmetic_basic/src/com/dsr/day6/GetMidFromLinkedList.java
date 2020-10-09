package com.dsr.day6;

import java.util.ArrayList;

/**
 * 给定头节点返回链表中间节点
 */
public class GetMidFromLinkedList {
    public static void main(String[] args) {
        Node test = null;
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(3);
        test.next.next.next.next = new Node(4);
        test.next.next.next.next.next = new Node(5);
        test.next.next.next.next.next.next = new Node(6);
        test.next.next.next.next.next.next.next = new Node(7);
        test.next.next.next.next.next.next.next.next = new Node(8);
        System.out.println(getMid1(test).value);
        System.out.println(right1(test).value);
        System.out.println("---------奇数中点，偶数下中点：-------");
        System.out.println(getMid2(test).value);
        System.out.println(right2(test).value);
        System.out.println("---------奇数中点前一个，偶数上中点前一个：-------");
        System.out.println(getMid3(test).value);
        System.out.println(right3(test).value);
    }

    /**
     * 奇数长度返回中点，偶数长度返回上中点
     * @param head
     * @return
     */
    public static Node getMid1(Node head){
        if(head==null || head.next==null || head.next.next==null)
            return head;
        Node slow=head.next;
        Node fast=head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node right1(Node head){
        if(head==null || head.next==null||head.next.next==null)
            return head;
        ArrayList<Node> list=new ArrayList<Node>();
        Node cur=head;
        while(cur!=null){
            list.add(cur);
            cur=cur.next;
        }
        Node res=list.size()%2==0?list.get(list.size()/2-1) : list.get(list.size()/2);
        return res;
    }

    /**
     * 奇数返回中点，偶数返回下中点
     * @param head
     * @return
     */
    public static Node getMid2(Node head){
        if(head == null || head.next==null || head.next.next==null)
            return head;
        Node slow=head.next;
        Node fast=head.next;
        while (fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node right2(Node head){
        if(head == null || head.next==null || head.next.next==null)
            return head;
        ArrayList<Node> list=new ArrayList<Node>();
        Node cur=head;
        while(cur != null){
            list.add(cur);
            cur=cur.next;
        }
        return list.size()%2 ==0 ?list.get(list.size()/2) :list.get(list.size()/2);
    }

    /**
     * 奇数返回中点前一个，偶数返回上中点前一个
     * @param head
     * @return
     */
    public static Node getMid3(Node head){
        if(head ==null || head.next ==null || head.next.next ==null)
            return head;
        Node slow=head;
        Node fast=head.next.next;
        while(fast.next !=null && fast.next.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node right3(Node head){
        if(head ==null || head.next ==null || head.next.next ==null)
            return head;
        ArrayList<Node> list=new ArrayList<>();
        Node cur=head;
        while(cur !=null){
            list.add(cur);
            cur=cur.next;
        }
        return list.size() % 2==0? list.get(list.size()/2-2) : list.get(list.size()/2-1);
    }
    static class Node{
        private int value;
        private Node next;
        public Node(){}
        public Node(int value){
            this.value=value;
        }
    }
}

