package practice.lesson2.fibonacci;

public class RecursiveFibonacci implements Fibonacci {

    @Override
    public int getNthFibonacciNumber(int n) {
        if (n <= 2) {
            return 1;
        }
        return getNthFibonacciNumber(n - 1) + getNthFibonacciNumber(n - 2);
    }
}
