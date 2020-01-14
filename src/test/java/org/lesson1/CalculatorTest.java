package org.lesson1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void calculateShouldReturnSumWhen1Plus2() {
        int actual = calculator.calculate(1, "+", 2);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateShouldReturnSumWhen3Plus2() {
        int actual = calculator.calculate(3, "+", 2);
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateShouldReturnSumWhen3Minus2() {
        int actual = calculator.calculate(3, "-", 2);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateShouldReturnSumWhen3Multiply2() {
        int actual = calculator.calculate(3, "*", 2);
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateShouldReturnSumWhen4Divide2() {
        int actual = calculator.calculate(4, "/", 2);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateShouldReturnSumWhen3Divide2() {
        int actual = calculator.calculate(3, "/", 2);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateShouldReturnIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        calculator.calculate(3, null, 2);

    }

}