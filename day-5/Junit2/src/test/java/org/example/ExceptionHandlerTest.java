package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionHandlerTest {

    private final ExceptionHandler exceptionHandler = new ExceptionHandler();

    @Test
    void testDivide_validDivision() {
        assertEquals(2, exceptionHandler.divide(4, 2));
        assertEquals(3, exceptionHandler.divide(9, 3));
        assertEquals(-2, exceptionHandler.divide(10, -5));
    }


    @Test
    void testDivide_byZero() {
        assertThrows(ArithmeticException.class, () -> {
            exceptionHandler.divide(10, 0);
        });
    }

    @Test
    void testDivide_byZeroWithMessage() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            exceptionHandler.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
