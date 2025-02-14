package banktransactionsystemtest;

import com.banktransactionsystem.InsufficientBalanceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.banktransactionsystem.BankTransactionSystem;

public class BankTransactionSystemTest {

    @Test
    void testInsufficientBalance() {
        Assertions.assertThrows(InsufficientBalanceException.class,
                () -> BankTransactionSystem.withdraw(20000)); // Withdraw more than balance
    }

    @Test
    void testIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> BankTransactionSystem.withdraw(-299)); // Negative withdrawal
    }

    @Test
    void testValidAmount() {
        Assertions.assertDoesNotThrow(() -> BankTransactionSystem.withdraw(2000)); // Valid withdrawal
    }
}
