package day6;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MapTest1 {
    public static void main(String[] args) {
        Hashtable hashtable=new Hashtable();
        hashtable.put(1,1);
        HashMap map=new HashMap();
        map.put(1,1);
        List list=new ArrayList();
        list=Collections.synchronizedList(list);
        CopyOnWriteArrayList copyList=new CopyOnWriteArrayList();
        copyList.add(11);
        copyList.get(0);
        ConcurrentSkipListMap skipListMap=new ConcurrentSkipListMap();
        skipListMap.put(1,1);
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put(1,1);

    }
}
