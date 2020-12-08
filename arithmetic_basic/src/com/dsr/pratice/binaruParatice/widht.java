package com.dsr.pratice.binaruParatice;

import java.util.LinkedList;
import java.util.Queue;

public class widht {
    public static void main(String[] args) {
        MyBinary binary=new MyBinary();
        int[] arr={8,9,6,2,5,11,45,32};
        for(int a: arr){
            binary.add(a);
        }
        width(binary.getRoot());
        System.out.println();
        System.out.println("树深度："+binary.getDepth(binary.getRoot().right));
        System.out.println("树最大宽度："+binary.getMaxWidth(binary.getRoot()));
    }
    public static void width(MyBinary.Node root){
        Queue<MyBinary.Node> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            root=queue.poll();
            System.out.print(root.value+"  ");
            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right != null){
                queue.offer(root.right);
            }
        }
    }
}
