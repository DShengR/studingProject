package com.dsr.pratice.sortParatice.first;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr=new int[]{5,7,4,6,1,3,8,5,6};
        insertSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void insertSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1])
                    swap(arr,j,j-1);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
