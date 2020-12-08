package com.dsr.mayi;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        //用于存放行数据
        List dataInfos=new LinkedList();
        dataInfos = Collections.synchronizedList(dataInfos);
        Comparator<String> comparator=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int id1=Integer.parseInt(o1);
                int id2=Integer.parseInt(o2);
                return id1-id2;
            }
        };
        //通过treeMap来实现排序
        TreeMap<String,DataInfo> treeMap =new TreeMap(comparator);
        File dir=new File("E:\\test");
        File[] files = dir.listFiles();
        //用CountDownLatch来实现文件解析任务与数据处理任务间的同步
        CountDownLatch latch=new CountDownLatch(files.length);
        //通过线程池来运行任务
        ExecutorService executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        //遍历需要处理的文件
        for(File file : files){
            //初始化解析文件的任务，每一个文件交给一个任务来处理
            Task dealFileTask = new DealFileTask(dataInfos,file,latch);
            //提交任务
            executorService.submit(dealFileTask);
        }
        //初始化数据处理的任务
        Task dealDataTask=new DealDataTask(dataInfos,treeMap,latch);
        //通过Future来保证数据处理任务与主线程打印间的顺序
        Future dataResult = executorService.submit(dealDataTask);
        try {
            dataResult.get();
            //当数据处理任务处理完成后再进行数据的打印操作
            System.out.println("----------结果-------------");
            for(DataInfo info : treeMap.values()){
                System.out.println(info);
            }
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
