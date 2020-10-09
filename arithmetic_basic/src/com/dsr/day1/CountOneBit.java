package com.dsr.day1;

public class CountOneBit {
    public static void main(String[] args) {
        int n=15;
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        int count=0;
        while(n!=0){
            int rightOne=n &(~n+1);
            count++;
            n^=rightOne;
        }
        System.out.println(count);
    }
}
