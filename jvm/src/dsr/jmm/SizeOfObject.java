package dsr.jmm;

import com.dsr.agent.SizeOfAgent;

public class SizeOfObject {
    public static void main(String[] args) {
        //Object对象
        Object obj=new Object();
        System.out.println("Object对象:"+SizeOfAgent.sizeOf(obj));//输出：16，mark word:8+classpointer:4(默认压缩)+实例数据:0+对齐:4
        //int数组，空数组
        int[] intArr=new int[]{};
        System.out.println("int空数组:"+SizeOfAgent.sizeOf(intArr));//输出：16，mark word:8+classpointer:4(默认压缩)+数组长度:4+数组数据:0+对齐:0
        //int数组，两个元素
        int[] intArr1=new int[2];
        System.out.println("int数组-两个元素:"+SizeOfAgent.sizeOf(intArr1));//输出：24，mark word:8+classpointer:4(默认压缩)+数组长度:4+数组数据:8+对齐:0
        //有值字符串
        String str=new String("1111111111s");
        System.out.println("有值字符串:"+SizeOfAgent.sizeOf(str));//输出：24，mark word:8+classpointer:4(默认压缩)+
        // String类中一个char[]数组(压缩后为4，实际数据指向数组对象)和一个int变量（4）+对齐：4
        //“”字符串
        String str1="";
        System.out.println("空字符串:"+SizeOfAgent.sizeOf(str1));//输出：24，mark word:8+classpointer:4(默认压缩)+
        // String类中一个char[]数组(压缩后为4)和一个int变量（4）+对齐：4
        //自定义类
        System.out.println("自定义类:"+SizeOfAgent.sizeOf(new P()));//输出32，mark word：8+class pointer:4+实例数据：20

    }
    static class P{
        private  static  String name;//4
        private final String gender;//4
        private int[] intArr;//4
        private long times;//8
        public P(){
            name="";
            gender="n";
            intArr=new int[2];
            times=111l;
        }
    }
}
