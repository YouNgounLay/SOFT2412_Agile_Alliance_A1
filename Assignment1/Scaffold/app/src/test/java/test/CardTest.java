package bank; 

import bank.Card;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CardTest { 
    
    private Card card;
    @BeforeEach 
    void init() { 
        card = new Card(100, "10", "Marcus"); 
    }

    @Test
    void testGetNumber() { 
        assertEquals(card.getNumber(), 100);
    }

    @Test
    void testGetStatus() {
        assertEquals(card.getStatus(), true);
    }

    @Test
    void testGetPin() {
        assertEquals(card.getPin(), "10");
    }

    @Test
    void testGetBalance() {
        assertEquals(card.getBalance(), 0);
    }

    @Test
    void testCheckExpiry() {
        assertTrue(card.checkExpiry());
    }

    @Test
    void testCheckExpiryCardExpired() {
        assertFalse(card.checkExpiryFutureTime()); 
    }

    @Test
    void testCheckIssueDate() {
        assertTrue(card.checkIssueDate());
    }

    @Test
    void testCheckIssueDateCardNotCreatedYet(){
        assertFalse(card.checkIssueDatePastTime());
    }

    @Test
    void testIsValid() {
        assertTrue(card.isValid());
    }

    @Test
    void testDeposit(){
        assertTrue(card.deposit(100000));
    }

    @Test
    void testWithdraw(){
        assertTrue(card.deposit(100000));
        assertFalse(card.withdraw(1000000));
        assertTrue(card.withdraw(100000));
    }


} 