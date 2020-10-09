package com.dsr.day3;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 求数组小和，在一个数组中一个数左边比它小的数的总和叫数的小和，所有数的小和累加起来叫数组的小和
 * 例[1,3,4,2,5]--数组小和为:16
 * 2.降序对
 */
public class ArrarMinSum {
    public static void main(String[] args) {
        int[] arr=new int[]{1,3,4,2,5,2};
        int sum=process(arr,0,arr.length-1);
        System.out.println(sum);
        System.out.println("======降序对======");
        int[] arr2=new int[]{1,3,4,2,5,2,0};
        int sum2=process2(arr2,0,arr2.length-1);
        System.out.println("降序对个数："+sum2);
    }
    public static int process(int[] arr,int L,int R){
        if(L==R){
            return 0;
        }
        int mid=L+((R-L)>>1);
        return  process(arr,L,mid)+
                process(arr,mid+1,R)+
                merge(arr,L,mid,R);
    }
    public  static int merge(int[] arr,int L,int mid ,int R){
        int p1=L;
        int p2=mid+1;
        int index=0;
        int[] help=new int[R-L+1];
        int sum=0;
        while(p1<=mid && p2<=R){
            sum+=(arr[p1]<arr[p2]?(R-p2+1)*arr[p1]:0);
            help[index++]=arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[index++]=arr[p1++];
        }
        while(p2<=R){
            help[index++]=arr[p2++];
        }
        for(int i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }
        return sum;
    }
    public static int process2(int[] arr,int L,int R){
        if(L== R)
            return 0;
        int mid=L+((R-L)>>1);
        int sum1=process2(arr,L,mid);
        int sum2=process2(arr,mid+1,R);
        int sum3=merge2(arr,L,mid,R);
        return  sum1+
                sum2+
                sum3;
    }
    public static int merge2(int[] arr ,int L,int mid,int R){
        int p1=L;
        int p2=mid+1;
        int index=0;
        int[] help=new int[R-L+1];
        int sum=0;
        while(p1<=mid && p2<=R){
            sum+=arr[p1]>arr[p2]?(mid-p1+1):0;
            help[index++]=arr[p1]>arr[p2]?arr[p2++]:arr[p1++];
        }
        while(p1<=mid){
            help[index++]=arr[p1++];
        }
        while(p2<=R){
            help[index++]=arr[p2++];
        }
        for(int i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }
        return sum;
    }
}
