package com.dsr.mayi;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public abstract  class Task implements Callable {
    /**
     * 需要处理的数据的集合
     */
    protected List<DataInfo> dataInfos;

    /**
     * 排序后数据的存放
     */
    protected TreeMap<String,DataInfo> treeMap;
    /**
     * 当前任务要处理的文件对象
     */
    protected File file;
    /**
     * 用于实现文件解析任务与数据处理任务间的线程同步
     */
    protected CountDownLatch latch;

    public Task(List<DataInfo> dataInfos, TreeMap<String,DataInfo> treeMap,CountDownLatch latch){
        this.dataInfos=dataInfos;
        this.treeMap=treeMap;
        this.latch=latch;
    }
    public Task(List<DataInfo> dataInfos, File file,CountDownLatch latch){
        this.dataInfos=dataInfos;
        this.file=file;
        this.latch=latch;
    }
    @Override
    public String call() {
        deal();
        return "deal success";
    }
    public abstract void  deal();
}
