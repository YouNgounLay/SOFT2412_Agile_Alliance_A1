package bank;

import bank.*;
 
import java.util.List; 
import java.util.ArrayList; 

public class Bank { 
    // This is the centralised database 
//    private final List<UserAccount> userAccounts = new ArrayList<>();
//    private final List<BankAccount> bankAccounts = new ArrayList<>();
    private final List<Card> userCards = new ArrayList<>();
    private final List<ATM> machines = new ArrayList<>();


    //*Card* Functionality
//    public Card getCard(int cardNumber) {
//        for (Card card :  userCards) {
//            if (card.getNumber() == cardNumber) {
//                return card;
//            }
//        }
//        return null;
//    }

//    public BankAccount getUserAccount(Card card){
//        return card.getAccount();
//    }
    
    public List<Card> getCardList() { 
        return this.userCards;
    }

    //would have to create new bank account before creating a new card
    public Card createNewCard(String name, String pin){
        int cardNumber = 10000+ userCards.size(); //check the card number requirements
        Card newCard = new Card(cardNumber, pin, name);
        this.userCards.add(newCard);
        return newCard;
    }

    public void removeCard(Card card){
        this.userCards.remove(card);
    }

    public void setCardStatus(Card card, boolean status){ //false = lost/stolen
        card.setStatus(status);
    }

    //*ATM* Functionality ---> need to check with what they've done in ATM
    public ATM createMachine() {
        ATM newATM = new ATM(this);
        this.machines.add(newATM);
        return newATM;
    }

    public List<ATM> getAtmList() {
        return this.machines;
    }

    public void removeMachine(ATM atm) {
        this.machines.remove(atm);
    }
}
