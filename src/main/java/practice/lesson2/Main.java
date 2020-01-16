package practice.lesson2;

public class Main {
    public static void main(String[] args) {
        A a = new A(100);

        final B b = new B("desc", a);

        System.out.println(b);

        a.setCode(200);

        System.out.println(b);
    }
}
