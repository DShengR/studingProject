package com.dsr.day1;

import util.BusiUtil;

import java.util.Arrays;

/**
 * 在有序数组中查找大于等于某个数最左边的数
 */
public class SearchLeftGeNum {
    public static void main(String[] args) {
        boolean successed=true;
        for(int i=0;i<50000;i++){
            int[] arr= BusiUtil.generateRandomArray(1000,500);
            Arrays.sort(arr);
//            for(int a:arr){
//                System.out.print(a+",");
//            }
            int num=arr[(int)(Math.random()*arr.length)];
            if(searchLeft(arr,num)!=nearLeft(arr,num)){
                successed=false;
                break;
            }
        }
        System.out.println(successed?"right":"error");
    }
    public static int searchLeft(int[] arr,int num){
        int L=0;
        int R=arr.length-1;
        int index=0;
        while(L <= R){
            int mid=(L+R)/2;
            if(arr[mid]>=num){
                index=mid;
                R=mid-1;
            }else{
                L=mid+1;
            }
        }
        return index;
    }
    public static int nearLeft(int[] arr,int num){
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==num){
                index=i;
                break;
            }
        }
        return index;
    }
}
