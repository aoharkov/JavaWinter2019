package practice.lesson3.functionalinterface;

public class InterfaceDemo {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterface() {
            @Override
            public void method() {
                System.out.println("anonimus");
            }
        };

        MyInterface lambda = () -> System.out.println("lambda anonimus");

        myInterface.method();
        lambda.method();

        OneParameter<String> oneParameter = message -> System.out.println(message.isEmpty());
        TwoParameter twoParameter = (message, n) -> {
            for (int i = 0; i < n; i++) {
                System.out.println(message);
            }
        };

    }
}
