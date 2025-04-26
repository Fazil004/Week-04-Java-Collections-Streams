package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    private final MathUtils mathUtils = new MathUtils();

    @Test
    void testDivide_validDivision() {
        assertEquals(2, mathUtils.divide(4, 2));
        assertEquals(3, mathUtils.divide(9, 3));
        assertEquals(-2, mathUtils.divide(10, -5));
    }

    @Test
    void testDivide_byZero() {
        assertThrows(ArithmeticException.class, () -> {
            mathUtils.divide(10, 0);
        });
    }

    @Test
    void testDivide_byZeroWithMessage() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            mathUtils.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testIsEven_evenNumbers(int number) {
        assertTrue(mathUtils.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void testIsEven_oddNumbers(int number) {
        assertFalse(mathUtils.isEven(number), number + " should be odd");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -2, -4, -6, -8})
    void testIsEven_negativeEvenNumbers(int number) {
        assertTrue(mathUtils.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -3, -5, -7, -9})
    void testIsEven_negativeOddNumbers(int number) {
        assertFalse(mathUtils.isEven(number), number + " should be odd");
    }
}
