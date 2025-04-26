package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {

    private final DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("24-07-2024", formatter.formatDate("2024-07-24"));
        assertEquals("01-01-2000", formatter.formatDate("2000-01-01"));
        assertEquals("31-12-2023", formatter.formatDate("2023-12-31"));
    }

    @Test
    void testInvalidDate_invalidFormat() {
        assertEquals("Invalid Date", formatter.formatDate("24-07-2024"));
        assertEquals("Invalid Date", formatter.formatDate("2024/07/24"));
        assertEquals("Invalid Date", formatter.formatDate("2024-July-24"));
    }

    @Test
    void testInvalidDate_invalidDate() {
        assertEquals("Invalid Date", formatter.formatDate("2024-02-30")); // Non-existent date
        assertEquals("Invalid Date", formatter.formatDate("2023-04-31")); //Non existent date
    }

    @Test
    void testNullDate() {
        assertNull(formatter.formatDate(null));
    }
}