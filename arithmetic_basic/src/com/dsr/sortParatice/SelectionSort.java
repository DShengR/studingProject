package com.dsr.sortParatice;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr=new int[]{5,7,4,6,1,3,8,5,6};
        sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static  void sort(int[] arr){
        if(arr==null || arr.length<=0){
            return;
        }
        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i;j<arr.length;j++){
                min=arr[j] > arr[min]?j:min;
            }
            swap(arr,min,i);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
