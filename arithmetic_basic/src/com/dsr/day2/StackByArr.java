package com.dsr.day2;

import java.util.Arrays;
import java.util.Stack;

public class StackByArr {
    private static class MyStack<T>{
        private Object[] elementData;
        private static final int DEFAULT_INITIAL_SIZE=10;
        private final Object[] EMPTY_ELEMENTDATA = {};
        private int size;
        public MyStack(){
            this(DEFAULT_INITIAL_SIZE);
        }
        public MyStack(int initSize){
            if(initSize>0)
                this.elementData=new Object[initSize];
            else if(initSize==0)
                elementData=EMPTY_ELEMENTDATA;
            else
                throw new IllegalArgumentException("Illegal Capacity: "+ initSize);
        }
        public void push(T t){
            ensureEnoughCapacity(elementData,size+1);
            elementData[size]=t;
            size++;
        }
        public Object pop(){
            if(size==0){
                return null;
            }
            Object value=elementData[--size];
            elementData[size]=null;
            return value;
        }
        public void ensureEnoughCapacity(Object[] elementData,int minSize){
            if(elementData==EMPTY_ELEMENTDATA){
                minSize=DEFAULT_INITIAL_SIZE;
            }
            if(minSize - elementData.length>0){
                grow(minSize);
            }
        }
        public void grow(int minSize){
            int oldLength=elementData.length;
            int newSize=oldLength+(oldLength>>1);
            newSize=(newSize-minSize>=0)?newSize:minSize;
            elementData=Arrays.copyOf(elementData, newSize);
        }
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
                    //System.out.println("push:"+nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                        //System.out.println("push:"+nums);
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
    public static boolean isEqual(Object o1, Object o2) {
       // System.out.println("o1:"+o1+",o2:"+o2);
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

}
