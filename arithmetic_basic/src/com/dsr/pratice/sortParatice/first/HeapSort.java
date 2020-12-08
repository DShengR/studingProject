package com.dsr.pratice.sortParatice.first;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr={8,7,9,6,2,5,11,45,32,11,0,44,2};
        heapSort(arr);
        for(int a :arr){
            System.out.println(a);
        }
    }
    public static void heapSort(int[] arr){
        int heapSize=arr.length;
        for(int i=arr.length-1;i>=0;i--){
            heapFiy(arr,i,heapSize);
        }

        while(heapSize>0){
            heapFiy(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }
    public static void heapFiy(int[] arr,int index,int heapSize){
        int left=index*2+1;
        while(left < heapSize){
            int largest=left+1<heapSize && arr[left+1]>arr[left] ?left+1 : left;
            largest = arr[index] > arr[largest] ? index:largest;
            if(largest == index) break;
            swap(arr , index ,largest);
            index=largest;
            left = largest*2 +1 ;
        }
    }
    public static void swap(int[] arr, int i ,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
