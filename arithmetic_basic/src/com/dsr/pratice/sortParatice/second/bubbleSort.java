package com.dsr.pratice.sortParatice.second;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr={23,12,44,45,23,6,8,4,2,1};
        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }

        for(int a: arr){
            System.out.println(a);
        }
    }

    public static void swap(int[] arr, int i ,int j){
        int temp=arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
