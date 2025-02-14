package throwvsthrowstest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.throwvsthrows.ThrowVsThrows;

class ThrowVsThrowsTest {

    @Test
    void testValidInterestCalculation() {
        double interest = ThrowVsThrows.calculateInterest(1000, 5, 2);
        assertEquals(100.0, interest, 0.001, "Interest calculation should be correct.");
    }

    @Test
    void testNegativeAmountThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> ThrowVsThrows.calculateInterest(-1000, 5, 2));
        assertEquals("Invalid input: Amount and rate must be positive", exception.getMessage());
    }

    @Test
    void testNegativeRateThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> ThrowVsThrows.calculateInterest(1000, -5, 2));
        assertEquals("Invalid input: Amount and rate must be positive", exception.getMessage());
    }

    @Test
    void testZeroValues() {
        double interest = ThrowVsThrows.calculateInterest(1000, 0, 2);
        assertEquals(0.0, interest, 0.001, "Interest should be zero when rate is 0.");
    }
}
