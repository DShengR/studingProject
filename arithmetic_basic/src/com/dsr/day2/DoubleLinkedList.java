package com.dsr.day2;

import com.sun.istack.internal.localization.NullLocalizable;

public class DoubleLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;
    public void add(T t){
        Node<T> newNode=new Node<T>(null,t,null);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            newNode.pre=tail;
            tail=newNode;
        }
        size++;
    }
    public T get(int index){
        check(index);
        return node(index).value;
    }
    public T remove(int index){
        check(index);
        Node<T> removedNode=node(index);
        return unlink(removedNode);
    }
    public boolean remove(Object t){
        if(t==null){
            Node<T> cur=head;
            for(int i=0;i<size;i++){
                if(cur.value==null){
                    unlink(cur);
                    return true;
                }
                cur=cur.next;
            }
        }else{
            Node<T> cur=head;
            for(int i=0;i<size;i++){
                if(t.equals(cur.value)){
                    unlink(cur);
                    return true;
                }
                cur=cur.next;
            }
        }
        return false;
    }
    public T unlink(Node<T> removedNode){
        Node<T> preNode=removedNode.pre;
        Node<T> nextNode=removedNode.next;
        T value=removedNode.value;
        if(preNode==null){
            head=nextNode;
        }else{
            preNode.next=nextNode;
            removedNode.next=null;
        }
        if(nextNode==null){
            tail=preNode;
        }else{
            nextNode.pre=preNode;
            removedNode.pre=null;
        }
        size--;
        return value;
    }
    public Node<T> node(int index){
        int mid=size>>1;
        if(index>=mid){
            Node<T> curNode=tail;
            for(int i=size-1;i>=mid;i--){
                if(index==i){
                    return curNode;
                }else{
                    curNode=curNode.pre;
                }
            }
        }else{
            Node<T> curNode=head;
            for(int i=0;i<mid;i++){
                if(index==i){
                    return curNode;
                }else{
                    curNode=curNode.next;
                }
            }
        }
        return null;
    }
    public int size(){
        return this.size;
    }
    private void check(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("size:"+size+",reequest:"+index);
        }
    }
    private class Node<T>{
        private T value;
        private Node pre;
        private Node next;
        Node(Node pre,T value,Node next){
            this.pre=pre;
            this.value=value;
            this.next=next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list=new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("size:"+list.size());

        int rem1=list.remove(0);
        System.out.println("删除的值："+rem1);
        for(int i=0;i< list.size();i++){
            System.out.println(i+":"+list.get(i));
        }
        int rem2=list.remove(0);
        System.out.println("删除的值："+rem2);
        int rem3=list.remove(0);
        System.out.println("删除的值："+rem3);
        for(int i=0;i< list.size();i++){
            System.out.println(i+":"+list.get(i));
        }
    }
}
