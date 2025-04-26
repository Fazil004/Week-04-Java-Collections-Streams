package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    StringUtils test  = new StringUtils();

    @Test
    void reverse() {
        assertEquals("ver", test.reverse("rev"));
        assertNotEquals("rev", test.reverse("rev"));
        assertEquals("321", test.reverse("123"));
    }

    @Test
    void isPalindrome() {
        assertTrue( test.isPalindrome("lol"));
        assertFalse( test.isPalindrome("string"));
    }

    @Test
    void toUpperCase() {
        assertEquals("LOL", test.toUpperCase("lol"));
        assertNotEquals("abcd", test.toUpperCase("abcd"));
    }

}