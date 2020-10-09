package com.dsr.day2;

public class QueueByArr<T> {
    private Object[] elementData;
    private static final int  LIMIT=10;
    private int size;
    private int offerIndex;
    private int pollIndex;
    public QueueByArr(){
        this.elementData=new Object[LIMIT];
    }
    public void offer(T t){
        if((size+1)>=LIMIT){
            throw new ArrayIndexOutOfBoundsException("length is "+LIMIT+",index is"+(size+1));
        }
        elementData[offerIndex]=t;
        size++;
        offerIndex=nextIndex(offerIndex);
    }
    public Object poll(){
        Object value=elementData[pollIndex];
        size--;
        pollIndex=nextIndex(pollIndex);
        return value;
    }
    private int nextIndex(int i){
        return (i >=(LIMIT-1))?0:i+1;
    }
    public int getSize(){
        return this.size;
    }

    public static void main(String[] args) {
        QueueByArr queue=new QueueByArr();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println("size:"+queue.getSize());
        int size=queue.getSize();
        for(int i=0;i<size;i++){
            System.out.println(queue.poll());
        }

    }
}

