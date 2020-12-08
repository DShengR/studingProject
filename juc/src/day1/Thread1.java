package day1;

public class Thread1 {
    public static void main(String[] args) {
        Test test=new Test();
        System.identityHashCode(test.o);
        test.method1();
    }
}
class Test{
    Object o=new Object();
    public void method1(){
        synchronized (o){
            System.out.println("o:"+o);
        }
    }
}
