package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance(), 0.001); // Use delta for double comparison
    }

    @Test
    void testDeposit_invalidAmount() {
        BankAccount account = new BankAccount(100);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50);
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(100);
        account.withdraw(30);
        assertEquals(70, account.getBalance(), 0.001);
    }

    @Test
    void testWithdraw_invalidAmount() {
        BankAccount account = new BankAccount(100);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-30);
        });
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }

    @Test
    void testWithdraw_insufficientFunds() {
        BankAccount account = new BankAccount(100);
        assertThrows(BankAccount.InsufficientFundsException.class, () -> {
            account.withdraw(150);
        });
    }

    @Test
    void testGetBalance() {
        BankAccount account = new BankAccount(100);
        assertEquals(100, account.getBalance(), 0.001);
    }
}