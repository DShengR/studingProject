package com.dsr.day1;

import util.BusiUtil;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        boolean successed=true;
        for(int testTime=0;testTime<100000;testTime++){
            int[] arr= BusiUtil.generateRandomArray(1000,1000);
            int[] orignArr= Arrays.copyOf(arr, arr.length);
            sort(arr);
            if(!BusiUtil.isRight(orignArr,arr)){
                successed=false;
                break;
            }
        }
        System.out.println(successed ?"right":"error");

    }
    public static void sort(int[] arr){
        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        arr[j]=arr[j]^arr[i];
        arr[i]=arr[j]^arr[i];
        arr[j]=arr[j]^arr[i];
    }
}
