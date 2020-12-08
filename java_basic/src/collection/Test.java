package collection;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        LocalTime
        HashMap<String,String> map=new HashMap();
        Hashtable table=new Hashtable();
        map.put(null,null);
        map.put("1",null);
        //table.put(null,1);
        //table.put(1,null);
/*        for(Map.Entry entry: map.entrySet()){
            map.remove(entry.getKey());
        }*/

        Set<String> strings = map.keySet();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Collection<String> values = map.values();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        ConcurrentHashMap<String,Object> conMap=new ConcurrentHashMap<>();
        conMap.put("1",null);

    }
}
