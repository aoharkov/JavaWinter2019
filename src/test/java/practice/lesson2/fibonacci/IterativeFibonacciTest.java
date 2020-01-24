package practice.lesson2.fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IterativeFibonacciTest {
    @Parameterized.Parameter
    public int n;
    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8},
                {7, 13}
        });
    }

    @Test
    public void getNthFibonacciNumber() {
        Fibonacci fibonacci = new IterativeFibonacci();
        assertEquals(expected, fibonacci.getNthFibonacciNumber(n));
    }
}