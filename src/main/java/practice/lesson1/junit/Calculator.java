package practice.lesson1.junit;

public class Calculator {

    public static final String MINUS = "-";
    public static final String PLUS = "+";
    public static final String MULT = "*";
    public static final String DIV = "/";

    public int calculate(int a, String operator, int b) {
        if (operator == null) {
            throw new IllegalArgumentException("operator is null");
        }
        switch (operator) {
            case PLUS:
                return a + b;
            case DIV:
                return a / b;
            case MULT:
                return a * b;
            default:
                return a - b;
        }
    }
}
