package junittesting;


import com.junit.advancedjunitpracticeproblems.PasswordValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testValidPasswords() {
        assertTrue(PasswordValidator.isValid("Test1234"));
        assertTrue(PasswordValidator.isValid("A1b2c3d4e5"));
        assertTrue(PasswordValidator.isValid("Secure99X"));
    }

    @Test
    void testInvalidPasswords() {
        assertFalse(PasswordValidator.isValid("test1234")); // No uppercase letter
        assertFalse(PasswordValidator.isValid("TESTTEST")); // No digit
    }
}
