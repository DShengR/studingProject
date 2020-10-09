package com.dsr.day2;
import java.util.Stack;

public class StackByDoubleList {
    private static class DoubleLinkedList<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;
        public void  insertFromHead(T t){
            Node<T> newNode=new Node<T>(null,t,null);
            if(head==null){
                head=newNode;
                tail=newNode;
            }else{
                newNode.next=head;
                head.pre=newNode;
                head=newNode;
            }
            size++;
        }
        public void  insertFromTail(T t){
            Node<T> newNode=new Node<T>(null,t,null);
            if(tail==null){
                head=newNode;
                tail=newNode;
            }else{
                newNode.pre=tail;
                tail.next=newNode;
                tail=newNode;
            }
            size++;
        }
        public T popFromHead(){
            if(head==null){
                return null;
            }
            T value=head.value;
            Node<T> cur=head;
            head=head.next;
            cur.next=null;
            cur=null;
            size--;
            return value;
        }
        public Object popFromTail(){
            if(tail==null){
                return null;
            }
            Object value=tail.value;
            Node cur=tail;
            tail=tail.pre;
            tail.next=null;
            cur.pre=null;
            size--;
            return value;
        }

        public boolean remove(Object t) {
            if (t == null) {
                Node<T> cur = head;
                for (int i = 0; i < size; i++) {
                    if (cur.value == null) {
                        unlink(cur);
                        return true;
                    }
                    cur = cur.next;
                }
            } else {
                Node<T> cur = head;
                for (int i = 0; i < size; i++) {
                    if (t.equals(cur.value)) {
                        unlink(cur);
                        return true;
                    }
                    cur = cur.next;
                }
            }
            return false;
        }

        public T unlink(Node<T> removedNode) {
            Node<T> preNode = removedNode.pre;
            Node<T> nextNode = removedNode.next;
            T value = removedNode.value;
            if (preNode == null) {
                head = nextNode;
            } else {
                preNode.next = nextNode;
                removedNode.next = null;
            }
            if (nextNode == null) {
                tail = preNode;
            } else {
                nextNode.pre = preNode;
                removedNode.pre = null;
            }
            size--;
            return value;
        }


        public int size() {
            return this.size;
        }

        private class Node<T> {
            private T value;
            private Node pre;
            private Node next;

            Node(Node pre, T value, Node next) {
                this.pre = pre;
                this.value = value;
                this.next = next;
            }
        }
    }
    private static class MyStack<T>{
        private DoubleLinkedList<T> list=null;
        public MyStack(){
            list=new DoubleLinkedList<>();
        }
        public void push(T t){
            list.insertFromHead(t);
        }
        public T pop(){
            return list.popFromHead();
        }
    }
    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }
    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }

}
