package com.dsr.day3;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr=new int[]{6,5,4,2,4,6,1,3,5,4};
        quickSort2(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }
    public static void quickSort1(int[] arr,int L,int R){
        if(L>=R){
            return;
        }
        int m=paration1(arr,L,R);
        quickSort1(arr,L,m-1);
        quickSort1(arr,m+1,R);
    }
    public static int paration1(int[] arr,int L,int R){
        if(L>R)
            return -1;
        if(L==R)
            return L;
        int lessParationIndex=L-1;
        int index=L;
        while(index<R){
            if(arr[index]<=arr[R]){
                swap(arr,++lessParationIndex,index);
            }
            index++;
        }
        swap(arr,R,++lessParationIndex);
        return lessParationIndex;
    }

    public static void quickSort2(int[] arr,int L,int R){
        if(L>=R){
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] index=paration2(arr,L,R);
        quickSort2(arr,L,index[0]-1);
        quickSort2(arr,index[1]+1,R);
    }
    public static int[] paration2(int[] arr,int L,int R){
        if(L>R)
            return new int[]{-1,-1};
        if(L==R)
            return new int[]{L,L};
        int lessParationIndex=L-1;
        int moreParationIndex=R;
        int index=L;
        while(index<moreParationIndex){
            if(arr[index]<arr[R]){
                swap(arr,++lessParationIndex,index++);
            }else if(arr[index]==arr[R]){
                index++;
            }else{
                swap(arr,--moreParationIndex,index);
            }
        }
        swap(arr,R,moreParationIndex);
        return new int[]{lessParationIndex+1,moreParationIndex};
    }

    public static void swap(int[] arr,int i,int j){
/*        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];*/
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
