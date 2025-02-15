package junittesting;

import com.junit.advancedjunitpracticeproblems.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        BankAccount account = new BankAccount(100.0);
        boolean result = account.withdraw(50.0);
        assertTrue(result);
        assertEquals(50.0, account.getBalance());
    }

    @Test
    void testWithdrawFailInsufficientFunds() {
        BankAccount account = new BankAccount(100.0);
        boolean result = account.withdraw(150.0);
        assertFalse(result);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void testWithdrawFailNegativeAmount() {
        BankAccount account = new BankAccount(100.0);
        boolean result = account.withdraw(-10.0);
        assertFalse(result);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50.0));
    }
}
