package com.dsr.day3;

public class ParationByNum {
    public static void main(String[] args) {
        int[] arr=new int[]{6,5,4,2,4,6,1,3,5,4};
        System.out.println(process(arr,4));
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println("=====分三区====");
        int[] arr2=new int[]{6,5,4,2,4,6,1,3,5,4};
        int[] index=process2(arr2,4);
        System.out.println(index[0]+","+index[1]);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr2[i]+",");
        }

    }
    public static int process(int[] arr,int num){
        int parationIndex=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=num){
                swap(arr,++parationIndex,i);
            }
        }
        return parationIndex;
    }
    public static int[] process2(int[] arr,int num){
        int lessParationIndex=-1;
        int moreParationIndex=arr.length;
        int index=0;
        while(moreParationIndex>index){
            if(arr[index]<num){
                swap(arr,++lessParationIndex,index++);
            }else if(arr[index]==num){
                index++;
            }else if(arr[index]>num){
                swap(arr,--moreParationIndex,index);
            }
        }
        return new int[]{lessParationIndex,moreParationIndex};
    }
    public static void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
}
