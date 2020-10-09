package com.dsr.day1;

import util.BusiUtil;
import java.util.Arrays;
//在有序数组中查找小于等于某个数的最右边的数
public class SearchRightLeNum {
    public static void main(String[] args) {
        boolean successed=true;
        for(int i=0;i<40000;i++){
            int[] arr= BusiUtil.generateRandomArray(2000,1000);
            Arrays.sort(arr);
//            for(int a:arr){
//                System.out.print(a+",");
//            }

            int num=arr[(int) (Math.random()*arr.length)];
           // System.out.println("查找的数："+num);
            int a=searchRight(arr,num);
            int b=nearLeft(arr, num);
//            System.out.println(a+"  --  "+b);
            if(a!=b){
                successed=false;
               // break;
            }
        }
        System.out.println(successed?"right":"error");

    }
    public static int searchRight(int[] arr,int num){
        int L=0;
        int R=arr.length-1;
        int index=0;
        while(L<=R){
            int mid =(L+R)/2;
            if(arr[mid]<=num){
                L=mid+1;
                index=mid;
            }else{
                R=mid-1;
            }
        }
        return index;
    }
    public static int nearLeft(int[] arr,int num){
        int index=0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==num){
                index=i;
                break;
            }
        }
        return index;
    }
}
