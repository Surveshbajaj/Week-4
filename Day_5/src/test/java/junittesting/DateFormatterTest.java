package junittesting;

import com.junit.advancedjunitpracticeproblems.DateFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {


    @Test
    void testValidDates() {
        assertEquals("15-02-2024", DateFormatter.formatDate("2024-02-15"));
        assertEquals("31-12-1999", DateFormatter.formatDate("1999-12-31"));
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"));
    }


    @Test
    void testInvalidDates() {
        assertNull(DateFormatter.formatDate("15-02-2024"));
        assertNull(DateFormatter.formatDate("02/15/2024"));

    }
}

