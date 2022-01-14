package test;
import test.*;

public class Card {  
    private ChequeAccount account; 
    private String name;
    private int cardNumber; 
    private String issueDate; 
    private String expDate;
    
    public Card(String name, int cardNumber, String issueDate, String expDate) {
        this.name = name;
        this.cardNumber = cardNumber; 
        this.issueDate = issueDate;
        this.expDate = expDate; 
    }
    
    public String getName() { 
        return this.name;
    }
     
    public void linkAccount(ChequeAccount account) { 
        this.account = account;
    }
    
    // For simplicity sake: 
    public boolean deposit(double amount) {
        return this.account.deposit(amount); 
    }

    public boolean withdraw(double amount) {
        return this.account.withdraw(amount);
    }
    
    public double getBalance() {
        return this.account.getBalance();
    }
    
    public ChequeAccount getAccount() { 
        return this.account; 
    } 
}