package com.dsr.mayi;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

/**
 * 处理文件内容，解析文件，生成DataInfo对象
 */
public class DealFileTask extends Task {

    public DealFileTask(List<DataInfo> dataInfos, File file, CountDownLatch latch) {
        super(dataInfos, file,latch);
    }

    @Override
    public void deal() {
        System.out.println(Thread.currentThread().getName()+"---"+file.getName());
        InputStreamReader in = null;
        BufferedReader reader = null;
        try{
            in=new InputStreamReader (new FileInputStream(file));
            reader=new BufferedReader(in);
            String line=null;
            String[] arrs=null;
            while((line=reader.readLine()) !=null){
                arrs= line.split(",");
                DataInfo info=new DataInfo(arrs[0],arrs[1],Float.parseFloat(arrs[2]));
                dataInfos.add(info);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            latch.countDown();
            System.out.println(Thread.currentThread().getName()+"--- count down");
            try{
                if(in != null){
                    in.close();
                }
                if(reader != null){
                    reader.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
