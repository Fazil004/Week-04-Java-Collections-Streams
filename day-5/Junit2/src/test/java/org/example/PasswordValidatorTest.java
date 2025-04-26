package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    private final PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password123"));
        assertTrue(validator.isValid("P@ssword1"));
        assertTrue(validator.isValid("123Password"));
    }

    @Test
    void testInvalidPassword_tooShort() {
        assertFalse(validator.isValid("Pass1"));
    }

    @Test
    void testInvalidPassword_noUppercase() {
        assertFalse(validator.isValid("password123"));
    }

    @Test
    void testInvalidPassword_noDigit() {
        assertFalse(validator.isValid("Password"));
    }

    @Test
    void testInvalidPassword_empty() {
        assertFalse(validator.isValid(""));
    }

    @Test
    void testInvalidPassword_null() {
        assertFalse(validator.isValid(null));
    }
}