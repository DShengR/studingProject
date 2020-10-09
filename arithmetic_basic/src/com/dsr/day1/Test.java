package com.dsr.day1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(7 | 1);
        int num=19;
        System.out.println(19&(~19+1));

        System.out.println((float)(15>>1));
        int[] arr=new int[]{1,2,3,4,5,6};
        System.arraycopy(arr,6,arr,5, 0);
        arr[5]=0;
        System.out.println("arr.length:"+arr.length);
        for(int a:arr){
            System.out.println(a);
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<=Integer.MAX_VALUE;i++){
            list.add(i);
        }
        System.out.println(list.get(Integer.MAX_VALUE));
    }
}
