package com.dsr.day1;

import util.BusiUtil;

import java.io.BufferedReader;
import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        boolean successed=true;
        for(int i=0;i<500000;i++){
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
        for(int i=0;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }

}
