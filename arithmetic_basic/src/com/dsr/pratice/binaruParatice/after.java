package com.dsr.pratice.binaruParatice;

import java.util.Stack;

public class after {
    public after(int i){

    }
    public static void main(String[] args) {
        MyBinary binary=new MyBinary();
        int[] arr={8,9,6,2,5,11,45,32};
        for(int a: arr){
            binary.add(a);
        }
        after1(binary.getRoot());
        System.out.println();
        after2(binary.getRoot());
    }
    public static void after1(MyBinary.Node root){

        if(root ==null) return;

        after1(root.left);

        after1(root.right);
        System.out.print(root.value+"  ");
    }

    public static void after2(MyBinary.Node root){
        Stack<MyBinary.Node> stack=new Stack<>();
        Stack<MyBinary.Node> data = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            data.push(root);
            if(root.left != null){
                stack.push(root.left);
            }
            if(root.right != null){
                stack.push(root.right);
            }
        }
        while(!data.isEmpty()){
            System.out.print(data.pop().value+"  ");
        }
    }
}
