package com.dsr.day2;

import java.util.Stack;

public class GetMinFromStack {
    private static class MyStack{
        Stack<Integer> dataStack=new Stack();
        Stack<Integer> minStack=new Stack<>();
        public void push(Integer value){
            dataStack.push(value);
            if(minStack.size()==0){
                minStack.push(value);
            }else if(minStack.peek()<=value){
                minStack.push(minStack.peek());
            }else{
                minStack.push(value);
            }
        }
        public Integer pop(){
            Integer value=dataStack.pop();
            minStack.pop();
            return value;
        }
        public Integer getMin(){
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MyStack stack=new MyStack();
        stack.push(6);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);


        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
