package com.dsr.day7;

import java.util.*;

/**
 * 构建二叉树
 */
public class BinaryTree<T> {
    private Comparator<T> comparator;
    private Node root;
    private int size=0;
    private class Node{
        private T value;
        private Node leftNode;
        private Node rightNode;
        public Node(T value,Node leftNode,Node rightNode){
            this.value=value;
            this.leftNode=leftNode;
            this.rightNode=rightNode;
        }
    }
    public BinaryTree(Comparator<T> comparator){
        this.comparator=comparator;
    }
    public void add(T value){
        Node t=root;
        if(t==null){
            root=new Node(value,null,null);
            size=1;
            return;
        }
        int flag=0;
        Node par=null;
        while(t !=null){
            par=t;
            flag=comparator.compare(value,t.value);
            if(flag< 0){
                t=t.leftNode;
            }else if(flag >= 0){
                t=t.rightNode;
            }
        }
        Node node=new Node(value,null,null);
        if(flag<0){
            par.leftNode=node;
        }else{
            par.rightNode=node;
        }
        size++;
    }

    /**
     * 递归先序遍历
     * @param node
     */
    public void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.value+" ");
        preOrder(node.leftNode);
        preOrder(node.rightNode);
    }

    /**
     * 非递归先序遍历
     * @param node
     */
    public void preOrder2(Node node){
        Stack<Node> stack=new Stack();
        stack.push(node);
        while(!stack.isEmpty()){
            Node head=stack.pop();
            System.out.print(head.value+" ");
            if(head.rightNode!=null){
                stack.push(head.rightNode);
            }
            if(head.leftNode != null){
                stack.push(head.leftNode);
            }
        }
        System.out.println();
    }

    /**
     * 递归中序遍历
     * @param node
     */
    public void midOrder(Node node){
        if(node == null){
            return;
        }
        midOrder(node.leftNode);
        System.out.print(node.value+" ");
        midOrder(node.rightNode);
    }

    /**
     * 非递归中序遍历
     * @param node
     */
    public void midOrder2(Node node){
        Stack<Node> stack=new Stack<>();
        while(!stack.isEmpty() || node !=null){
            if(node !=null){
                stack.push(node);
                node=node.leftNode;
            }else{
                node=stack.pop();
                System.out.println(node.value+" ");
                stack.push(node.rightNode);
            }
        }
        System.out.println();
    }

    /**
     * 递归后序遍历
     * @param node
     */
    public void afterOrder(Node node){
        if(node == null){
            return;
        }
        afterOrder(node.leftNode);
        afterOrder(node.rightNode);
        System.out.print(node.value+" ");
    }

    /**
     * 后序非递归遍历
     * @param node
     */
    public void afterOrder2(Node node){
        Stack<Node> stack=new Stack<>();
        Stack<Node> data=new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            Node head=stack.pop();
            data.push(head);
            if(head.leftNode !=null){
                stack.push(head.leftNode);
            }
            if(head.rightNode !=null){
                stack.push(head.rightNode);
            }
        }
        System.out.println();
    }

    /**
     * 按层遍历，即广度（宽度）优先遍历
     * @param node
     */
    public void levelOrder(Node node){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            node=queue.poll();
            System.out.print(node.value+" ");
            if(node.leftNode != null){
                queue.offer(node.leftNode);
            }
            if(node.rightNode != null){
                queue.offer(node.rightNode);
            }
        }
        System.out.println();
    }

    /**
     * 树的最大宽度
     * @param node
     * @return
     */
    public int getMaxWidth(Node node){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(node);
        Node curEnd=node;
        Node nextEnd=null;
        int max=0;
        int curLevelNodes=0;
        while(!queue.isEmpty()){
            node=queue.poll();
            if(node.leftNode !=null){
                queue.offer(node.leftNode);
                nextEnd=node.leftNode;
            }
            if(node.rightNode != null){
                queue.offer(node.rightNode);
                nextEnd=node.rightNode;
            }
            curLevelNodes++;
            if(node==curEnd){
                max=Math.max(max, curLevelNodes);
                curLevelNodes=0;
                curEnd=nextEnd;
            }
        }
        return max;
    }
    public Queue preSerial(Node head){
        Queue<String> list=new LinkedList<>();
        preSerial(head,list);
        return list;
    }
    private void preSerial(Node node,Queue list){
        if(node == null) list.add(null);
        else{
            list.add(String.valueOf(node.value));
            preSerial(node.leftNode);
            preSerial(node.rightNode);
        }
    }

    public Node preUnSerial(Queue list){
        Node head=preUnSerial1(list);
        return head;
    }
    private Node preUnSerial1(Queue<String> list){
        String value=list.poll();
        if(value==null){
            return null;
        }
        Node node=new Node((T)Integer.valueOf(value),null,null);
        node.leftNode = preUnSerial1(list);
        node.leftNode = preUnSerial1(list);
        return node;
    }

    public Node getRoot(){
        return root;
    }
    public int getDeep(Node node){
        if(node == null){
            return 0;
        }
        int leftDepth = getDeep(node.leftNode);
        int rightDepth = getDeep(node.rightNode);
        return (leftDepth > rightDepth) ? leftDepth+1 : rightDepth+1;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree=new BinaryTree<>((a,b)->a-b);
        int[] arr={ 5, 2, 9, 1, 3, 6, 12, 4, 5 };
        for(int a: arr){
            tree.add(a);
        }
        System.out.println("------递归先序-------");
        tree.preOrder(tree.getRoot());
        System.out.println();
        System.out.println("------非递归先序-------");
        tree.preOrder(tree.getRoot());
        System.out.println();

        System.out.println("------递归中序-------");
        tree.midOrder(tree.getRoot());
        System.out.println();
        System.out.println("------非递归中序-------");
        tree.midOrder(tree.getRoot());
        System.out.println();

        System.out.println("------递归后序-------");
        tree.afterOrder(tree.getRoot());
        System.out.println();
        System.out.println("------非递归后序-------");
        tree.afterOrder(tree.getRoot());
        System.out.println();

        System.out.println("------宽度优先遍历-------");
        tree.levelOrder(tree.getRoot());

        System.out.println();
        System.out.println("------树的深度-----");
        System.out.println(tree.getDeep(tree.getRoot()));

        System.out.println();
        System.out.println("------树的最大宽度-----");
        System.out.println(tree.getMaxWidth(tree.getRoot()));
    }
}
