package com.dsr.day4;

import java.util.Comparator;

/**
 * 自定义堆结构
 * 堆：通常是用数组结构实现的完全二叉树
 * 大根堆：所有父节点的值比子节点值大
 * 小根堆：所有父节点的值比子节点值小
 * 任意数组中小标为i的节点，其左孩子节点在数组中的下标为2*i+1,其左孩子节点在数组中的下标为2*i+2,其父节点在数组中的下标为(i-1)/2
 */
public class MyHeap<T> {
    private Integer[] heap;
    private int limit;
    private int size;

    public MyHeap(int limit) {
        heap = new Integer[limit];
        size = 0;
        this.limit = limit;
    }

    public void push(Integer t) {
        if (size >= limit)
            throw new ArrayIndexOutOfBoundsException("limit:" + limit + ",now:" + size--);
        heap[size] = t;
        heapInsert(size++);
    }

    public Integer pop() {
        if (size ==0)
            throw new ArrayIndexOutOfBoundsException("limit:" + limit + ",now:" + size++);
        size--;
        Integer value = heap[0];
        heap[0] = heap[size];
        heapFiy(0);
        return value;
    }

    private void heapInsert(int index) {
        while (heap[index] > heap[(index - 1) / 2]) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapFiy(int index) {
        int left=2*index+1;
        while(left < size){
            int largest = left+1<size  &&  heap[left+1] > heap[left] ? left+1 : left;
            //int largest = left+1<size  &&  heap[left] > heap[left+1] ? left : left+1;
            largest = (heap[index] > heap[largest]) ? index : largest;
            if(largest==index) break;
            swap(largest,index);
            index=largest;
            left=2*index+1;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

    private void swap(int i, int j) {
        Integer temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap(8);
        myHeap.push(8);
        myHeap.push(7);
        myHeap.push(9);
        myHeap.push(6);
        myHeap.push(2);
        myHeap.push(5);
        System.out.println(myHeap.pop());
        System.out.println(myHeap.pop());
        System.out.println(myHeap.pop());
        System.out.println(myHeap.pop());
        System.out.println(myHeap.pop());
        System.out.println(myHeap.pop());


        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            MyHeap my = new MyHeap(curLimit);
            RightMaxHeap test = new RightMaxHeap(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops--11!");
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("Oops--11!!");
                }
                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                } else if (my.isFull()) {
                    Object o1=my.pop();
                    Object o2=test.pop();
                    // System.out.println("myheap"+o1+",--rightHeap"+o2);

                    if (!o1.equals(o2)) {
                        System.out.println("Oops!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else {
                        Object o1=my.pop();
                        Object o2=test.pop();
                        // System.out.println("myheap"+o1+",--rightHeap"+o2);
                        if (!o1.equals(o2)) {
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }

    public static class RightMaxHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeap(int limit) {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }

    }

}
