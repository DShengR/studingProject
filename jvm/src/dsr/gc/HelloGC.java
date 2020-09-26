package dsr.gc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        int i=0;
        try {
            List<Object> list = new LinkedList<>();
            for (; ; ) {
                i++;
                byte[] b = new byte[1024];
                list.add(b);
            }
        }catch(Error e){
            System.out.println(i);
            throw e;
        }
    }
}
