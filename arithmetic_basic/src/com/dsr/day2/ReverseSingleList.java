package com.dsr.day2;

import util.BusiUtil;

public class ReverseSingleList {
    public static void main(String[] args) {
        boolean successed=true;
        for(int i=0;i<10000;i++){
            BusiUtil.Node head = BusiUtil.generateSingleListHeadNode(1000, 1000);
            SingleLinkedList singleLinkedList = BusiUtil.generateSingleList(head);
            head=reverseList(head);
            successed=checkLinkedListReverse(singleLinkedList, head);
        }
        System.out.println(successed?"right":"error");
    }
    public static BusiUtil.Node reverseList(BusiUtil.Node head){
        if(head==null){
            return null;
        }
        BusiUtil.Node pre=null;
        BusiUtil.Node next=null;
        while(head != null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
    public static boolean checkLinkedListReverse(SingleLinkedList list,BusiUtil.Node head){
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
