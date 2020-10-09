package com.dsr.day2;

import java.util.LinkedList;

public class SingleLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;
    public class Node<T>{
        public T value;
        public Node next;
        public Node(T t){
            this.value=t;
        }
    }
    public SingleLinkedList(){
    }
    public void add(T t){
        Node<T> newNode=new Node<T>(t);
        size++;
        if(head == null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
    }
    public T get(int index){
        check(index);
        Node<T> node=node(index);
        return node.value;
    }
    public T remove(int index){
        check(index);

        if(index==0){
            Node<T> node=node(index);
            T value=node.value;
            head=node.next;
            size--;
            return value;
        }else{
            Node<T> preNode=node(index-1);
            Node<T> removedNode=preNode.next;
            T value=removedNode.value;
            preNode.next=removedNode.next;
            size--;
            return value;
        }
    }
    public int size(){
        return this.size;
    }

    private Node node(int index){
        Node cur=head;
        for(int i=0;i<size;i++){
            if(i==index){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    private void check(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("size:"+size+",reequest:"+index);
        }
    }
    public static void main(String[] args) {
        SingleLinkedList<Integer> list=new SingleLinkedList();
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
