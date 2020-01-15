package practice.lesson1.reflection;

class A {
    private A(int i) {
        System.out.println(i);
    }

    private void method() {
        System.out.println("Nonstatic method");
    }

    private static void staticMethod() {
        System.out.println("Static method");
    }
}
