package dsr.runtimedatearea;

public class JvmStack {
    public static void main(String[] args) {
        int i=8;
        //i=i++;
        i=++i;
        System.out.println(i);
    }
    public void test(String str,int i){
        int j=i;
        String k=str;
        long lo=0l;
        System.out.println(j+","+k);
    }
}
