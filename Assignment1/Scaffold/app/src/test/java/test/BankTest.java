package bank;

import bank.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank bank; 
    private Card cardTest1; 
    private ATM atmTest1; 

    @BeforeEach
    void init() {
        bank = new Bank();
        cardTest1 = bank.createNewCard("Mia", "1234");
        atmTest1 = bank.createMachine();
    }

    // @BeforeEach
    // void reset(){
    //     for(Card card : bank.getCardList()){
    //         bank.removeCard(card);
    //     }
    //     for(ATM machine : bank.getAtmList()) {
    //         bank.removeMachine(machine);
    //     }
    // }

    @Test
    void testCreateNewCard() {
        //Test it was created and returned
        assertNotNull(bank.createNewCard("Phil", "5678"));
        //Test it was added to bank list
        assertEquals(bank.getCardList().size(), 2);
        //Test functioning of number assignment
        assertEquals(bank.getCardList().get(1).getNumber(), 10001);
    }

    @Test
    void testGetCardList() {
        assertEquals(bank.getCardList().get(0), cardTest1);
        assertEquals(bank.getCardList().size(), 1);
    }

    @Test
    void testRemoveCard() {
        bank.removeCard(cardTest1);
        assertEquals(bank.getCardList().size(), 0);
    }

    @Test
    void testSetCardStatus() {
        //Test True
        bank.setCardStatus(cardTest1, true);
        assertTrue(cardTest1.getStatus());
        //Test False
        bank.setCardStatus(cardTest1, false);
        assertFalse(cardTest1.getStatus());
    }

    @Test
    void testCreateMachine() {
        //Test ATM machine was created and returned
        assertNotNull(bank.createMachine());
        //Test it was added to ATM machines list
        assertEquals(bank.getAtmList().size(), 2);
    }

    @Test
    void testRemoveMachine() {
        bank.removeMachine(atmTest1);
        assertEquals(bank.getAtmList().size(), 0);
    }

    @Test
    void testGetAtmList() {
        assertEquals(bank.getAtmList().get(0), atmTest1);
        assertEquals(bank.getAtmList().size(), 1);
    }
}