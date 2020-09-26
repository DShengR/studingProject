package dsr.classloader;

public class DclSingleton {
    private static volatile  DclSingleton singleton;
    public static DclSingleton getInstance(){
        if(singleton==null){
            synchronized (DclSingleton.class){
                if(singleton == null){
                    singleton=new DclSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {

        DclSingleton single1=DclSingleton.getInstance();
    }
}
