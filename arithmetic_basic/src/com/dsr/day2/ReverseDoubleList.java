package com.dsr.day2;

import util.BusiUtil;

public class ReverseDoubleList {
    public static void main(String[] args) {
        boolean successed=true;
        for(int i=0;i<1;i++){
            BusiUtil.DoubleNode head = BusiUtil.generateDoubleListHeadNode(100, 100);
            DoubleLinkedList doubleLinkedList = BusiUtil.generateDoubleList(head);
            head=reverseList(head);
           successed=checkLinkedListReverse(doubleLinkedList, head);
        }
        System.out.println(successed?"right":"error");
    }
    public static BusiUtil.DoubleNode reverseList(BusiUtil.DoubleNode head){
        if(head==null){
            return null;
        }
        BusiUtil.DoubleNode pre=null;
        BusiUtil.DoubleNode next=null;
        while(head !=null){
            next=head.next;
            head.pre=next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return  pre;
    }
    public static boolean checkLinkedListReverse(DoubleLinkedList list,BusiUtil.DoubleNode head){
        if(list.size()==0 && head==null){
            return true;
        }
        for(int i=list.size()-1;i>=0;i--){
            System.out.println("list:"+list.get(i)+",node.value"+head.value);
            if(list.get(i)!=head.value){
                return false;
            }
            head=head.next;
        }
        return true;
    }
}
