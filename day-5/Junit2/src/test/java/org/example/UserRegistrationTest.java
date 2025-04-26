package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    private final UserRegistration registration = new UserRegistration();

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> registration.registerUser("testuser", "test@example.com", "password123"));
        assertDoesNotThrow(() -> registration.registerUser("user123", "user@test.org", "Pass1234"));
    }

    @Test
    void testInvalidRegistration_nullUsername() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser(null, "test@example.com", "password123");
        });
        assertEquals("Username cannot be null or empty", exception.getMessage());
    }

    @Test
    void testInvalidRegistration_emptyUsername() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("", "test@example.com", "password123");
        });
        assertEquals("Username cannot be null or empty", exception.getMessage());
    }

    @Test
    void testInvalidRegistration_nullEmail() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("testuser", null, "password123");
        });
        assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    void testInvalidRegistration_emptyEmail() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("testuser", "", "password123");
        });
        assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    void testInvalidRegistration_invalidEmailFormat() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("testuser", "invalid_email", "password123");
        });
        assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    void testInvalidRegistration_nullPassword() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("testuser", "test@example.com", null);
        });
        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }

    @Test
    void testInvalidRegistration_shortPassword() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("testuser", "test@example.com", "pass1");
        });
        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }
}