package dsr.gc;

public class StackError {
    public static void main(String[] args) {
        m();
    }
    private static void  m(){
        m();
    }
}
