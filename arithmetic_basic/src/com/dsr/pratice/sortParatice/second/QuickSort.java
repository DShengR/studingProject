package com.dsr.pratice.sortParatice.second;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={23,12,44,45,23,6,8,4,2,1};
        QuickSort sort=new QuickSort();
        sort.quickSort(arr,0,arr.length-1);
        for(int a: arr){
            System.out.println(a);
        }
    }
    public void quickSort(int[] arr,int left,int right){
        if(left >= right) return;

        swap(arr,right,left+(int)Math.random()*(right-left+1));
        int[] index=helan(arr,left,right);
        quickSort(arr,left,index[0]-1);
        quickSort(arr,index[1]+1,right);

    }
    public int[] helan(int[] arr, int left, int right){
        if(left == right){
            return new int[]{1,1};
        }
        if(left > right){
            return new int[]{-1,-1};
        }
        int lessIndex=left-1;
        int moreIndex=right;
        int index=left;
        while(index < moreIndex){
            if(arr[index] > arr[right]){
                swap(arr,index,--moreIndex);
            }else if(arr[index]==arr[right]){
                index++;
            }else{
                swap(arr,++lessIndex,index++);
            }
        }
        swap(arr,moreIndex,right);
        return new int[]{lessIndex+1,moreIndex};
    }
    public void swap(int[] arr, int i ,int j){
        int temp=arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
