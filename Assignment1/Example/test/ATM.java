package test; 

import test.*;
public class ATM {  
    private Card card;

    public void insertCard(Card card) {
        if (this.card != null) { 
            System.out.println("\nThere is currently a card being used!");
            return; 
        }
        this.card = card; 
        System.out.println("\nCard Insertion Success!"); 
        this.displayInfo();
    }

    public void displayInfo() {
        System.out.println("\nUser: " + card.getName());
        System.out.println("Current Balance: " + card.getBalance()); 
    }

    public void deposit(double amount) {
        boolean success = card.deposit(amount); 
        String msg = success ? "Deposit Successful" : "Deposit Failed"; 
        System.out.println(msg); 
        displayInfo();
    }

    public void withdraw(double amount) {
        boolean success = card.withdraw(amount); 
        String msg = success ? "Withdrawal Successful" : "Withdrawal Failed"; 
        System.out.println(msg); 
        displayInfo();
    }
    
    public void ejectCard() {
        this.card = null; 
        System.out.println("\nEjecting Card....\nThanks for Using!");
    }

}