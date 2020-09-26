package dsr.bytecode;


import dsr.classloader.DclSingleton;

public class Main extends SuperMain {
/*    private static int b=11111;
    private String c="dsr";
    private String[] arrs=new String[]{"1","3"};*/
    private volatile String d="ddd";

    public void test(){
        System.out.println(d);
    }

    public static void main(String[] args) {
    }
}
