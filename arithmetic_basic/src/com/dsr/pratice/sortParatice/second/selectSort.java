package com.dsr.pratice.sortParatice.second;

public class selectSort {
    public static void main(String[] args) {
        int[] arr={23,12,44,45,23,6,8,4,2,1};

/*        for(int i=0;i<arr.length-1;i++){
            int max=0;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j] > arr[max]){
                    max=j;
                }
            }
            swap(arr,max,arr.length-1-i);
        }*/

        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min=j;
                }
            }
            swap(arr,min,i);
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
