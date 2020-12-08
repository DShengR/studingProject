package com.dsr.pratice.sortParatice.second;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr={23,12,44,45,23,6,8,4,2,1};
        HeapSort sort=new HeapSort();
        sort.heapSort(arr);
        for(int a: arr){
            System.out.println(a);
        }
    }
    public void heapSort(int[] arr){
        int size=arr.length;
        for(int i=arr.length-1;i>=0;--i){
            heapFiy(arr,i,size);
        }
        while(size > 0){
            heapFiy(arr,0,size);
            swap(arr,0 ,--size);
        }
    }
    public void heapFiy(int[] arr,int index,int size){
        int left=index*2+1;
        while(left <size){
            int largest=left+1 < size && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(largest == index) break;
            swap(arr , index ,largest);
            index = largest;
            left = index * 2 +1;
        }
    }
    public void swap(int[] arr, int i ,int j){
        int temp=arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
