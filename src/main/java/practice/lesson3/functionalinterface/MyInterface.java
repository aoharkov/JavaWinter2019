package practice.lesson3.functionalinterface;

@FunctionalInterface
public interface MyInterface {
    int A = 10;

    void method();

    default void method1() {

    }
}
