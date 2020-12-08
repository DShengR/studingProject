package com.dsr.pratice.binaruParatice;

import java.util.Stack;

public class pre {
    public static void main(String[] args) {
        MyBinary binary=new MyBinary();
        int[] arr={8,9,6,2,5,11,45,32};
        for(int a: arr){
            binary.add(a);
        }
        binaryPre1(binary.getRoot());
        System.out.println();
        binaryPre2(binary.getRoot());
    }
    public static void binaryPre1(MyBinary.Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value+"  ");
        binaryPre1(head.left);

        binaryPre1(head.right);
    }

    public static void binaryPre2(MyBinary.Node head){
        if(head == null) return;
        Stack<MyBinary.Node> stack=new Stack();
        stack.push(head);
        while(!stack.isEmpty()){
            MyBinary.Node node=stack.pop();
            System.out.print(node.value+"  ");
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }
}
