package com.dsr.pratice.binaruParatice;

import java.util.Stack;

public class mid {
    public static void main(String[] args) {
        MyBinary binary=new MyBinary();
        int[] arr={8,9,6,2,5,11,45,32};
        for(int a: arr){
            binary.add(a);
        }
        binaryMid1(binary.getRoot());
        System.out.println();
        binaryMid2(binary.getRoot());
    }
    public static void binaryMid1(MyBinary.Node node){

        if(node == null) return;

        binaryMid1(node.left);
        System.out.print(node.value+"  ");
        binaryMid1(node.right);
    }
    public static void  binaryMid2(MyBinary.Node root){
        Stack<MyBinary.Node> stack=new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root !=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                System.out.print(root.value+"  ");
                root=root.right;
            }
        }
    }
}
