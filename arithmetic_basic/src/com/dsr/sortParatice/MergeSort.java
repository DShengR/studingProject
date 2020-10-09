package com.dsr.sortParatice;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr=new int[]{5,7,4,6,1,3,8,5,6};
        mergeSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void mergeSort(int[] arr){
        process(arr,0,arr.length-1);
    }
    public static void process(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int mid=l+((r-l)>>1);
        process(arr,l,mid);
        process(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    public static void merge(int[] arr,int l,int mid,int r){
        int[] help=new int[r-l+1];
        int p1=l;
        int p2=mid+1;
        int index=0;
        while(p1<=mid && p2<=r){
            help[index++]=arr[p1]>arr[p2]? arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[index++]=arr[p1++];
        }
        while(p2<=r){
            help[index++]=arr[p2++];
        }
        for(int i=0;i<help.length;i++){
            arr[l+i]=help[i];
        }
    }
}
