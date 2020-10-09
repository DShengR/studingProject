package com.dsr.day1;

import util.BusiUtil;

import java.util.Arrays;

public class NumExistsInSortedArr {
    public static void main(String[] args) {
        boolean successed=true;
        for(int i=0;i<50000;i++){
            int[] arr= BusiUtil.generateRandomArray(1000, 1000);
            Arrays.sort(arr);
            if(!search(arr,arr[(int)Math.random()*arr.length])) {
                successed = false;
                break;
            }
        }
        System.out.println(successed?"right":"error");
    }
    public static boolean search(int[] arr,int num){
        int L=0;
        int R=arr.length-1;
        while(L<=R){
            //int mid=(L+R)/2;//(2L+R-L)/2  --> L+(R-L)/2  --> L+(R-L)>>1
            int mid= L+(R-L)>>1;
            if(arr[mid]==num){
                return true;
            }else if(arr[mid] >num){
                R=mid-1;
            }else{
                L=mid+1;
            }
        }
        return arr[L]==num;
    }
}
