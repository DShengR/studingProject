package dsr.classloader;

public class PathScop {
    public static void main(String[] args) {
        System.out.println("--------------启动类加载器----------------");
        String bootStrapPath = System.getProperty("sun.boot.class.path");
        System.out.println(bootStrapPath.replaceAll(";",System.lineSeparator()));


        System.out.println("--------------扩展类加载器----------------");
        String extPath = System.getProperty("java.ext.dirs");
        System.out.println(extPath.replaceAll(";",System.lineSeparator()));

        System.out.println("--------------应用类加载器----------------");
        String appPath = System.getProperty("java.class.path");
        System.out.println(appPath.replaceAll(";",System.lineSeparator()));
    }
}
