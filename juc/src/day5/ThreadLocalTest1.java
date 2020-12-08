package day5;

import sun.misc.Unsafe;

import java.util.WeakHashMap;

public class ThreadLocalTest1 {
    static ThreadLocal<Integer> local=new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return 1;
        }
    };
    public static void main(String[] args) {
        local.set(2);

        System.out.println(local.get());
        local.remove();
        System.out.println(local.get());

        WeakHashMap hashMap=new WeakHashMap();
        hashMap.put(null,11);
        System.out.println(hashMap.get(null));
    }
}
