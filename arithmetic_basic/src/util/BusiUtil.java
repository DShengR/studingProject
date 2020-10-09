package util;
import com.dsr.day2.DoubleLinkedList;
import com.dsr.day2.SingleLinkedList;

import java.util.Arrays;

public class BusiUtil {
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr=new int[(int)(Math.random()*maxSize)+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*maxValue)+1-(int)(Math.random()*maxValue);
        }
        return arr;
    }
    public static boolean isRight(int[] origin,int[] sorted){
        Arrays.sort(origin);
        for(int i=0;i<origin.length;i++){
            if(origin[i]!=sorted[i]){
                return false;
            }
        }
        return true;
    }
    public static Node generateSingleListHeadNode(int maxSize, int maxValue){
        int len=(int)(Math.random()*maxSize+1);
        if(len==0){
            return null;
        }
        Node headNode=new Node((int)(Math.random()*maxValue+1));
        len--;
        Node cur=headNode;
        while(len>0){
            Node node=new Node((int)(Math.random()*maxValue+1));
            cur.next=node;
            cur=node;
            len--;
        }
        return headNode;
    }
    public static SingleLinkedList generateSingleList(Node<Integer> head){
        SingleLinkedList<Integer> list=new SingleLinkedList<Integer>();
        while(head!=null){
            list.add(head.value);
            head=head.next;
        }
        return list;
    }


    public static DoubleNode<Integer> generateDoubleListHeadNode(int maxSize, int maxValue){
        int len=(int)(Math.random()*maxSize+1);
        if(len==0){
            return null;
        }
        DoubleNode<Integer> headNode=new DoubleNode<Integer>(null,(int)(Math.random()*maxValue+1),null);
        len--;
        DoubleNode<Integer> cur=headNode;
        while(len>0){
            DoubleNode<Integer> node=new DoubleNode<Integer>(cur,(int)(Math.random()*maxValue+1),null);
            cur.next=node;
            cur=node;
            len--;
        }
        return headNode;
    }
    public static DoubleLinkedList generateDoubleList(DoubleNode<Integer> head){
        DoubleLinkedList<Integer> list=new DoubleLinkedList<Integer>();
        while(head!=null){
            list.add(head.value);
            head=head.next;
        }
        return list;
    }
    public static class Node<T>{
        public T value;
        public Node next;
        public Node(T t){
            this.value=t;
        }
    }
    public static class DoubleNode<T>{
        public T value;
        public DoubleNode next;
        public DoubleNode pre;
        public DoubleNode(DoubleNode pre,T value,DoubleNode next){
            this.pre=pre;
            this.value=value;
            this.next=next;
        }
    }
}
