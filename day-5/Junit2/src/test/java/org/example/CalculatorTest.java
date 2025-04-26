package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(0, 0));
        assertEquals(-1, calculator.add(-2, 1));
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    void testSubtraction() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(0, calculator.subtract(5, 5));
        assertEquals(-2, calculator.subtract(3, 5));
        assertEquals(-1, calculator.subtract(-3, -2));
        assertEquals(5, calculator.subtract(2, -3));
    }

    @Test
    void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(0, 5));
        assertEquals(-6, calculator.multiply(2, -3));
        assertEquals(6, calculator.multiply(-2, -3));
        assertEquals(1, calculator.multiply(1, 1));
    }

    @Test
    void testDivision() {
        assertEquals(2.5, calculator.divide(5, 2));
        assertEquals(2, calculator.divide(4, 2));
        assertEquals(-2.5, calculator.divide(-5, 2));
        assertEquals(2.5, calculator.divide(-5, -2));
        assertEquals(0.5, calculator.divide(1, 2));
    }

    @Test
    void testDivisionByZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0), "Dividing by zero should throw an IllegalArgumentException");
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}