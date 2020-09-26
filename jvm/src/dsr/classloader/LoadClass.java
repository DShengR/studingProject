package dsr.classloader;

public class LoadClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Class pathScopeClass=LoadClass.class.getClassLoader().loadClass("dsr.classloader.PathScop");
    }
}
