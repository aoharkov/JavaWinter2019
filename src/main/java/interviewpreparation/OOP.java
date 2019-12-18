package interviewpreparation;

public class OOP {
    public static void main(String[] args) {
        question1();
    }

    private static void question1() {
        A a = new B();
        System.out.println(a.name);
        System.out.println(a.staticName);
        System.out.println(a.getName());
        System.out.println(a.getStaticName());
    }
}

class A {
    String name = "nameA";
    String staticName = "staticNameA";

    A() {
        System.out.println("Constructor A");
        print();
        printPrivate();
    }

    public void print() {
        System.out.println("A.print()");
        print2();
    }

    public void print2() {
        System.out.println("A.print2()");
    }

    private void printPrivate() {
        System.out.println("A.printPrivate()");
    }

    public String getName() {
        return name;
    }

    public String getStaticName() {
        return staticName;
    }
}

class B extends A {
    String name = "nameB";
    String staticName = "staticNameB";

    B() {
        System.out.println("Constructor B");
        print();
        printPrivate();
    }

    public void print() {
        System.out.println("B.print()");
        print2();
    }

    public void print2() {
        System.out.println("B.print2()");
    }

    private void printPrivate() {
        System.out.println("B.printPrivate()");
    }

    public String getName() {
        return name;
    }

    public String getStaticName() {
        return staticName;
    }
}