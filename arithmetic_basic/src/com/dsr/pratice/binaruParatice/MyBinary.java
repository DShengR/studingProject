package com.dsr.pratice.binaruParatice;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinary {
    private Node root;
    class Node{
         int value;
         Node left;
         Node right;
        public Node(int value,Node left,Node right){
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }
    public void add(int val){
        Node node=new Node(val,null,null);
        if(root == null){
            root=node;
        }else{
            Node t = root;
            Node pre=null;
            while(t != null){
                pre=t;
                if(t.value>val){
                    t = t.left;
                }else{
                    t = t.right;
                }
            }
            if(pre.value > val){
                pre.left = node;
            }else{
                pre.right = node;
            }
        }
    }
    public Node getRoot(){
        return root;
    }
    public int getDepth(Node node){
        if(node==null) return 0;
        int left=getDepth(node.left);
        int right = getDepth(node.right);
        return left > right ? left+1:right+1;
    }
    public int getMaxWidth(Node node){
        Queue<Node> queue=new LinkedList<>();
        Node curEnd=node;
        Node nextEnd=null;
        int max=0;
        int curLevelCnt=0;
        queue.offer(node);
        while(!queue.isEmpty()){
            node=queue.poll();
            if(node.left !=null){
                nextEnd=node.left;
                queue.offer(node.left);
            }
            if(node.right !=null) {
                nextEnd=node.right;
                queue.offer(node.right);
            }
            curLevelCnt++;
            if(node == curEnd){
                max=Math.max(max,curLevelCnt);
                curEnd=nextEnd;
                curLevelCnt=0;
            }
        }
        return max;
    }
}
