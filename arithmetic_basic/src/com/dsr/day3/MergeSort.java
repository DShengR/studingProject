package com.dsr.day3;
//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] arr=new int[]{5,7,8,6,4,2,3,1};
        process(arr,0,arr.length-1);
        for(int a:arr){
            System.out.print(a+",");
        }
    }
    public static void process(int[] arr,int L,int R){
        if(L==R){
            return ;
        }
        int mid=L+((R-L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }
    public static void merge(int[] arr,int L,int mid,int R){
        int p1= L;
        int p2=mid+1;
        int index=0;
        int[] help=new int[R-L+1];
        while(p1<=mid && p2<=R){
            help[index++]=arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[index++]=arr[p1++];
        }
        while(p2<=R){
            help[index++]=arr[p2++];
        }
        for(int i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }
    }
}
