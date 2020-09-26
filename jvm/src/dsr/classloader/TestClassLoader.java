package dsr.classloader;

import dsr.bytecode.Main;
import com.sun.nio.zipfs.JarFileSystemProvider;

import java.io.File;
import java.util.List;
import java.util.Map;

public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(String.class.getClassLoader());
        System.out.println(List.class.getClassLoader());

        System.out.println(JarFileSystemProvider.class.getClassLoader());
        System.out.println(Main.class.getClassLoader());

        System.out.println(JarFileSystemProvider.class.getClassLoader().getClass().getClassLoader());
        System.out.println(Main.class.getClassLoader().getClass().getClassLoader());

    }
}
