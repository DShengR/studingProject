package com.dsr.sortParatice;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr=new int[]{5,7,4,6,1,3,8,5,6};
        bubbleSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static  void bubbleSort(int[] arr){
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        arr[i]=arr[i] ^ arr[j];
        arr[j]=arr[i] ^ arr[j];
        arr[i]=arr[i] ^ arr[j];
    }
}
