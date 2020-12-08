package com.dsr.pratice.binaruParatice;
import java.util.*;

public class Joseph {
    public static int getResult(int n) {
        // write code here
        int cur=2;
        int index=0;
        int ori=n;
        while( n!=1){
            n=(n/cur+n%cur);
            cur++;
            index++;
        }
        index--;
        return ori%2==0 ? ((ori-1)/index - (ori-1)%index) : (ori/index - ori%index);
    }

    public static void main(String[] args) {
        int a=getResult(5);
        System.out.println(a);
    }
}