package com.dsr.day1;

import util.BusiUtil;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) throws Exception {
        boolean successed=true;
        for(int i=0;i<500000;i++){
            int[] arr=BusiUtil.generateRandomArray(1000, 1000);
            int[] originArr=Arrays.copyOf(arr, arr.length);
            int[] sorted=sort(arr);
            if(!BusiUtil.isRight(originArr,sorted)){
                successed=false;
                break;
            }
        }
        System.out.println(successed ?"right":"error");
    }
    public static int[] sort(int[] arr){
        if(arr==null || arr.length<2){
            return arr;
        }
        for(int i=0;i<arr.length;i++){
            int index=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[index]){
                    index=j;
                }
            }
            swap(arr,i,index);
        }
        return arr;
    }
    public static void  swap(int[] arr,int i,int j){
        int swap=arr[i];
        arr[i]=arr[j];
        arr[j]=swap;
    }
}
