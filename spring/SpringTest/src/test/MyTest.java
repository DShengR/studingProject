package test;

import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void test01(){
        Map map=new HashMap();
        List checkList=new ArrayList();
        map.put("array",checkList);
        Map innerMap=new HashMap();
        innerMap.put("id", "111");
        innerMap.put("name", "dsr");
        innerMap.put("size", "2");
        checkList.add(innerMap);
        List innerArr=new ArrayList();
        Map innerSubMap=new HashMap();
        innerSubMap.put("subid", "1111_1");
        innerSubMap.put("name", "dsr_1");
        innerArr.add(innerSubMap);
        innerMap.put("subArr",innerArr);

        List innerArr2=new ArrayList();
        Map innerSubMap2=new HashMap();
        innerSubMap2.put("subid", "1111_2");
        innerSubMap2.put("name", "dsr_2");
        innerArr2.add(innerSubMap2);
        innerMap.put("subArr2",innerArr2);


        System.out.println(map);
    }
    @Test
    public void test02(){
        Map map=new HashMap();
        List outList=new ArrayList();
        for(int i=0;i<2;i++){
            Map outListMap=new HashMap();

            outListMap.put("id", "111_"+i);
            outListMap.put("name","dsr_"+i);
            outListMap.put("size", "2_"+i);
            List innerList=new ArrayList();
            for(int j=0;j<3;j++){
                Map innerListMap=new HashMap();
                innerListMap.put("country", "中国_"+j);
                innerListMap.put("province", "甘肃_"+j);
                innerList.add(innerListMap);
            }
            outListMap.put("innerArr", innerList);
            outList.add(outListMap);
        }
        map.put("outArr" ,outList);
        System.out.println(map);
    }
}
