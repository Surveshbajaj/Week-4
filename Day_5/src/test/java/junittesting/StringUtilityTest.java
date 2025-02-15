package junittesting;

import static org.junit.jupiter.api.Assertions.*;

import com.junit.basicjunittest.StringUtils;
import org.junit.jupiter.api.Test;

class StringUtilityTest {

    @Test
    void testReverse() {
        assertEquals("dcba", StringUtils.reverse("abcd"));
        assertEquals("54321", StringUtils.reverse("12345"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null)); // Handle null input
    }

    @Test
    void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("madam"));
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertTrue(StringUtils.isPalindrome("Mom")); // Case insensitive
        assertFalse(StringUtils.isPalindrome("hello"));
        assertFalse(StringUtils.isPalindrome("Java"));
        assertFalse(StringUtils.isPalindrome(null)); // Null case should return false
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));
        assertEquals("WORLD", StringUtils.toUpperCase("WoRlD"));
        assertEquals("", StringUtils.toUpperCase(""));
        assertNull(StringUtils.toUpperCase(null)); // Null input should return null
    }
}
