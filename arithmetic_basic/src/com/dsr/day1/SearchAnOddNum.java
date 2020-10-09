package com.dsr.day1;

import com.sun.xml.internal.messaging.saaj.util.SAAJUtil;

public class SearchAnOddNum {
    public static void main(String[] args) {
        int[] arr=new int[]{1,1,2,2,2,3,3,3,3,4,4,5,5,6,6,6,6};
        int eor=0;
        for(int i=0;i<arr.length;i++){
            eor=eor^arr[i];
        }
        System.out.println(eor);
    }
}
