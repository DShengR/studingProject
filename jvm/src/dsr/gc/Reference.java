package dsr.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Reference {
    public static void main(String[] args) {
        Object object=new Object();
        ReferenceQueue queue=new ReferenceQueue();
        ReferenceQueue queue2=new ReferenceQueue();
        SoftReference soft=new SoftReference(object,queue2);
        System.out.println("soft:"+soft.get());
        WeakReference weak=new WeakReference(object,queue2);
        System.out.println("weak:"+weak.get());

        PhantomReference phantom=new PhantomReference(new Object(),queue);
        object=null;
        System.out.println("phantom:"+phantom.get());
        System.out.println("reference queue:"+queue.poll());
        System.out.println("reference queue22:"+queue2.poll());
        System.out.println("reference queue33:"+queue2.poll());
        List list=new ArrayList();
        try {
            for (; ; ) {
                byte[] bytes = new byte[1024 * 1024];
                list.add(bytes);
            }
        }catch (Error e){
            throw e;
        }finally{
            java.lang.ref.Reference reference = queue.poll();
            if (reference != null) System.out.println("garbage:" + reference);

            java.lang.ref.Reference reference2 = queue2.poll();
            if (reference2 != null) System.out.println("garbage2222:" + reference2);

            java.lang.ref.Reference reference3 = queue2.poll();
            if (reference3 != null) System.out.println("garbage3333:" + reference3);
        }
    }
}
