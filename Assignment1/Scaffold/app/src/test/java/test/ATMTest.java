package bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class ATMTest {


    private Bank bank;
    private ATM atm;
    private Card first;
    private Card ray;
    private Card marcus;
    private Card mia;
    private Card daniel;
    private Card phillip;
    private List<Card> cardList;
    
    @BeforeEach 
    void reset() {
        bank = new Bank();
        atm = bank.createMachine();
        first = bank.createNewCard("First", "10000");
        ray = bank.createNewCard("Ray", "10001");
        marcus = bank.createNewCard("Marcus", "10002");
        mia = bank.createNewCard("Mia", "10003");
        daniel = bank.createNewCard("Daniel", "10004");
        phillip = bank.createNewCard("Phillip", "10005");
        cardList = bank.getCardList(); 
    }
    
    @Test
    void testInsertCard() {

        assertEquals(atm.insertCard(10006), false);
        atm.ejectCard();
        assertEquals(atm.insertCard(10005), true);
        atm.ejectCard();
        assertEquals(atm.insertCard(10003), true);
        atm.ejectCard();
    }
    @Test
    void testCurrentCard() {

        assertNull(atm.getCurrentCard());
        atm.insertCard(10003);
        assertEquals(atm.getCurrentCard(), mia);
        atm.ejectCard();
        assertNull(atm.getCurrentCard());
        atm.insertCard(10001);
        assertNotEquals(atm.getCurrentCard(), phillip);
        atm.ejectCard();
    }

    @Test
    void testCheckAndAddFunds() {

        assertEquals(atm.getFunds(), 0);
        atm.addFunds(100000);
        assertEquals(atm.getFunds(), 100000);
        atm.addFunds(20000);
        assertEquals(atm.getFunds(), 120000);
    }

    @Test
    void testInsertPin() {

        atm.insertCard(10005);
        assertEquals(atm.enterPin("11111"), false);
        assertEquals(atm.enterPin("10005"), true);
        atm.ejectCard();

    }

    @Test
    void ATMFunds() {

        ray.deposit(1000);
        atm.insertCard(10001);
        atm.addFunds(120000);
        boolean success = atm.withdraw(1000);
        assertEquals(success, true);
        atm.ejectCard();
        marcus.deposit(119000);
        atm.insertCard(10002);
        boolean successTwo = atm.withdraw(119000);
        assertEquals(successTwo, true);
        atm.ejectCard();
        daniel.deposit(1000);
        atm.insertCard(10004);
        boolean successThree = atm.withdraw(1000);
        assertEquals(successThree, false);
        atm.addFunds(1000);
        boolean successFour = atm.withdraw(1000);
        assertEquals(successFour, true);
        atm.ejectCard();

    }

    @Test
    void testATMFunctions() {
        atm.addFunds(500000);
        atm.insertCard(10001);
        atm.deposit(1000);
        double money = ray.getBalance() + 1000;
        boolean success = atm.withdraw(money);
        assertEquals(success, false);
        success = atm.withdraw(money - 1000);
        assertEquals(success, true);
        money = ray.getBalance();
        success = atm.deposit(1000);
        assertEquals(ray.getBalance(), money + 1000);
        atm.ejectCard();
        assertFalse(atm.withdraw(1000));
        assertFalse(atm.deposit(1000));

    }

    @Test
    void testStatusCheck() {
        phillip.setStatus(false);
        boolean success = atm.insertCard(10005);
        assertEquals(success, true);
        assertEquals(false, atm.checkStatus());
        assertTrue(atm.getConfiscatedCards().contains(phillip));
        atm.ejectCard();
    }

    @Test
    void testCheckBalance() {
        double money = ray.getBalance();
        ray.deposit(1000);
        assertEquals(atm.checkBalance(), -1);
        atm.insertCard(10001);
        assertEquals(ray.getBalance(), money + 1000);
        atm.ejectCard();
    }

}
