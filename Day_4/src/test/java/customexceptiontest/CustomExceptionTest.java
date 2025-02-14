package customexceptiontest;

import com.customexception.CustomException;
import com.customexception.InvalidAgeException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomExceptionTest {

    @Test
    void testValidAge() {
        assertDoesNotThrow(() -> CustomException.validateAge(18)); // Should not throw an exception

    }


    @Test
    void testInvalidAge() {
        Exception exception = assertThrows(InvalidAgeException.class, () -> CustomException.validateAge(17)); // Should throw exception
        assertEquals("Age must be 18 or above", exception.getMessage());
    }
}
