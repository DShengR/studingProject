package com.dsr.sortParatice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] args) {
        Map<String,String> map1=new HashMap<>();
        map1.put("dsr","ddd");
        System.out.println(map1.size());
        for(String key:map1.keySet()){
            System.out.println(key+"="+map1.get(key));
        }
        for(String value:map1.values()){
            System.out.println(value);
        }
        for(Map.Entry entry:map1.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        System.out.println(tableSizeFor(9));
    }
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
