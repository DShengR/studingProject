package com.dsr.day6;

import java.util.Stack;

/**
 * 回文链表
 */
public class PalindromeList {
    static class Node{
        private int value;
        private Node next;
        public Node(){}
        public Node(int value){
            this.value=value;
        }
    }
    public static void main(String[] args) {

    }

    /**
     * 判断是否是回文链表
     * @param head
     * @return
     */
    public boolean isPalindromeList1(Node head){
        if(head ==null || head.next==null){
            return true;
        }
        Stack<Node> stack=new Stack<>();
        Node cur=head;
        while(cur != null){
            stack.push(cur);
            cur=cur.next;
        }
        cur=head;
        while(cur != null){
            if(cur!=stack.pop())
                return false;
            cur=cur.next;
        }
        return true;
    }
    public static Node reverseSingleList(Node head){
        if(head ==null || head.next==null){
            return head;
        }
        Node pre=null;
        Node next=null;
        while(head !=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
