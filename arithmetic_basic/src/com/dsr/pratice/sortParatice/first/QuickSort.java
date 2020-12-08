package com.dsr.pratice.sortParatice.first;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr=new int[]{5,7,4,6,1,3,8,5,6};
//        int[] index=helanFlag(arr,0,arr.length-1);
//        for(int a:arr){
//            System.out.print(a+",");
//        }
//        System.out.println();
//        System.out.println(index[0]+","+index[1]);
        quickSort(arr);
        for(int a:arr){
            System.out.print(a+",");
        }
    }
    public static void quickSort(int[] arr){
        process(arr,0,arr.length-1);
    }
    public static void process(int[] arr,int l,int r){
        if(l>=r){
            return ;
        }
        swap(arr,r,l+(int)Math.random()*(r-l+1));
        int[] index=helanFlag(arr,l,r);
        process(arr,l,index[0]-1);
        process(arr,index[1]+1,r);
    }
    public static int[] helanFlag(int[] arr,int l,int r){
        if(l>r){
            return new int[]{-1,-1};
        }
        if(l==r){
            return new int[]{l,l};
        }
        int lessIndex=l-1;
        int moreIndex=r;
        int index=l;
        while(moreIndex > index){
            if(arr[index]>arr[r]){
                swap(arr,index,--moreIndex);
            }else if(arr[index]==arr[r]){
                index++;
            }else{
                swap(arr,index++,++lessIndex);
            }
        }
        swap(arr,moreIndex,r);
        return new int[]{lessIndex+1,moreIndex};
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
