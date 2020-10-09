package com.dsr.day6;

/**
 * 链表分区
 */
public class ParationList {
    static class Node{
        private int value;
        private Node next;
        public Node(){}
        public Node(int value){
            this.value=value;
        }
    }
    public static void main(String[] args) {
/*        int[] arr=new int[]{4,8,7,5,6,9,5,3,2};
        parationArr(arr,5);
        for(int a: arr){
            System.out.println(a);
        }*/
        System.out.println("------------");
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        Node head=parationList1(head1,5);
        while(head !=null){
            System.out.println(head.value);
            head=head.next;
        }
    }
    public static Node parationList1(Node head,int num){
        if(head ==null || head.next==null){
            return head;
        }
        int len=0;
        Node cur=head;
        while(cur !=null){
            len++;
            cur=cur.next;
        }
        Node[] arr=new Node[len];
        int index=0;
        while(head !=null){
            arr[index++]=head;
            head=head.next;
        }
        parationArr(arr,num);
        head=arr[0];
        Node res=head;
        for(int i=1;i<arr.length;i++){
            Node node=arr[i];
            head.next=node;
            head=node;
        }
        head.next=null;
        return res;
    }
    /*荷兰国旗问题--数组分区*/
    public static void parationArr(Node[] arr,int num){
        int lessIndex=-1;
        int moreIndex=arr.length;
        int index=0;
        while(moreIndex>index){
            if(arr[index].value > num){
                swap(arr,index,--moreIndex);
            }else if(arr[index].value==num){
                index++;
            }else {
                swap(arr,index++,++lessIndex);
            }
        }
    }
    public static void swap(Node[] arr,int i,int j){
        Node temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
