package test;

import java.util.Date; 
import java.util.List;
import java.util.ArrayList; 
import test.*;

// Assuming this is the Bank itself
public class Program {
    
    public static void main(String[] args) { 
        int cardNumber = 1234; 

        List<CustomerAccount> customers = new ArrayList<>();
        
       // A user enter the bank to create a new user account  
        CustomerAccount dan = new CustomerAccount("dan", "12/14/1980"); 
        customers.add(dan);
        System.out.println("Creating Personal Account: " + dan.getName());
    
      // The customer then would like to open a cheque Account 
      // We create the new bank account
        ChequeAccount danPersonalAccount = new ChequeAccount(cardNumber, 1234); 
      
     // then link the new bank account to dan 
        dan.addAccount(danPersonalAccount);  

     // We then offer a card to Dan with his account 
        Card danCard = new Card("dan", cardNumber, "11/21", "11/25" ); 
        dan.addCard(danCard);
        danCard.linkAccount(danPersonalAccount);
        cardNumber++;
    
    // Let's say dan wants to create another bank account for his business
    // Repeats the Above 
        System.out.println("Creating Business Account: "); 
        ChequeAccount danBusinessAccount = new ChequeAccount(cardNumber, 1234);
        dan.addAccount(danBusinessAccount); 
    // Unlike Previously we do not link this to a card 
        
    ATM machine = new ATM(); 

        machine.insertCard(danCard);
        machine.deposit(500);
        machine.ejectCard();
    
        
    }
}