package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    private final TemperatureConverter converter = new TemperatureConverter();

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32, converter.celsiusToFahrenheit(0), 0.1);
        assertEquals(212, converter.celsiusToFahrenheit(100), 0.1);
        assertEquals(68, converter.celsiusToFahrenheit(20), 0.1);
        assertEquals(-40, converter.celsiusToFahrenheit(-40), 0.1);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0, converter.fahrenheitToCelsius(32), 0.1);
        assertEquals(100, converter.fahrenheitToCelsius(212), 0.1);
        assertEquals(20, converter.fahrenheitToCelsius(68), 0.1);
        assertEquals(-40, converter.fahrenheitToCelsius(-40), 0.1);
    }

    @Test
    void testCelsiusToFahrenheit_fractional() {
        assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.1);
    }

    @Test
    void testFahrenheitToCelsius_fractional() {
        assertEquals(37, converter.fahrenheitToCelsius(98.6), 0.1);
    }
}