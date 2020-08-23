package com.dsr.Adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class AdapterClient {
    public static void main(String[] args) throws FileNotFoundException {
        //要按行读取，首先得将字节流转化为字符流，InputStreamReader就是一个适配器
        FileInputStream inputStream=new FileInputStream("");
        InputStreamReader reader=new InputStreamReader(inputStream);
        BufferedReader br=new BufferedReader(reader);
    }
}
