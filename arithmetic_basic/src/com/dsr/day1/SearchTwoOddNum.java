package com.dsr.day1;

public class SearchTwoOddNum {
    public static void main(String[] args) {
        int[] arr=new int[]{1,1,2,2,3,3,3,4,4,4,4,5,6,6,6,6};
        int eor=0;
        for(int i=0;i<arr.length;i++){
            eor=eor^arr[i];
        }
        int rightOne=eor&(~eor+1);
        int eor2=0;
        for(int i=0;i<arr.length;i++){
            if((rightOne & arr[i]) !=0){
                eor2 ^=arr[i];
            }
        }
        int a=eor2;
        int b=eor ^ eor2;
        System.out.println(a+"  ---  "+b);
    }
}
