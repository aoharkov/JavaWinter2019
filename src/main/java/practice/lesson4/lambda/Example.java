package practice.lesson4.lambda;

import java.util.function.Function;

public class Example {
    public static void main(String[] args) {
        final String name = "Sir";
        //name = "Name2"; - name should be final or effective final
        Function<String, String> printMessage = x -> {
            System.out.println(x);
            return "Yes, " + name;
        };
        System.out.println(printMessage.apply("Print my message"));
    }
}
