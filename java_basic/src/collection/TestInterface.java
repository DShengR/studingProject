package collection;

public interface TestInterface {
    default void test(){
        System.out.println(1);
    }
}
