package practice.lesson2.fibonacci;

public class IterativeFibonacci implements Fibonacci {
    @Override
    public int getNthFibonacciNumber(int n) {
        if (n <= 2) {
            return 1;
        }
        int current = 1;
        int before = 1;
        for (int i = 3; i <= n; i++) {
            int next = current + before;
            before = current;
            current = next;
        }
        return current;
    }
}
