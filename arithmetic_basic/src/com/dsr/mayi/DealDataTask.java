package com.dsr.mayi;

import java.io.File;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * 数据处理任务
 */
public class DealDataTask extends Task {
    public DealDataTask(List<DataInfo> dataInfos, TreeMap<String,DataInfo> treeMap,CountDownLatch latch){
        super(dataInfos,treeMap,latch);
    }
    @Override
    public void deal() {
        try {
            latch.await();
            System.out.println(Thread.currentThread().getName()+"-- data 处理");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(DataInfo dataInfoList : dataInfos){
            DataInfo dataInfoMap = treeMap.get(dataInfoList.getGroupId());
            if(dataInfoMap == null){
                //该groupId还未参与排序，直接放到treeMap中
                treeMap.put(dataInfoList.getGroupId(),dataInfoList);
            }else{
                //该groupId已经参与过排序，进行指标值的比较，将较小的放进去
                Float quotaList = dataInfoList.getQuota();
                Float quotaMap = dataInfoMap.getQuota();
                if(quotaList.compareTo(quotaMap) <0){
                    treeMap.remove(dataInfoMap.getGroupId());
                    treeMap.put(dataInfoList.getGroupId(),dataInfoList);
                }
            }
        }
    }
}
