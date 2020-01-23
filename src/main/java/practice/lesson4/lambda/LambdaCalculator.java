package practice.lesson4.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntBiFunction;

public class LambdaCalculator {
    private static final Map<String, ToIntBiFunction<Integer, Integer>> OPERATOR_TO_OPERATION = new HashMap<>();

    static {
        OPERATOR_TO_OPERATION.put("+", Integer::sum);
        OPERATOR_TO_OPERATION.put("-", (a, b) -> a - b);
    }

    private int calculate(int a, String operator, int b) {
        return OPERATOR_TO_OPERATION.get(operator).applyAsInt(a, b);
    }

    public static void main(String[] args) {
        LambdaCalculator calculator = new LambdaCalculator();
        System.out.println(calculator.calculate(2, "+", 2));
        System.out.println(calculator.calculate(3, "-", 2));
    }
}

