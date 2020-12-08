package com.dsr.pratice.sortParatice.second;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={23,12,44,45,23,6,8,4,2,1};
        MergeSort sort=new MergeSort();
        sort.mergeSort(arr,0,arr.length-1);
        for(int a: arr){
            System.out.println(a);
        }
    }
    public void mergeSort(int[] arr,int l,int r){
        if(l==r) return ;

        int mid=(r+l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    public void merge(int[] arr,int l,int mid,int r){
        int[] help=new int[r-l+1];
        int p1=l;
        int p2=mid+1;
        int index=0;
        while(p1<=mid && p2<=r){
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
