package bank.UI.InputState;  

import bank.ATM;
import bank.Bank;
import bank.UI.TextColor; 
import bank.UI.InputState.UserInputState;
import bank.UI.UserInputHandler;
import bank.UI.InputState.DefaultState;

import java.util.Scanner; 

public class CardVerificationState implements UserInputState {
    private final String displayMessage = TextColor.blue + "\n\n\nAGILE ALLIANCE ATM\n" + TextColor.reset  
                                        + TextColor.green + "\nPlease Choose One of the Following Action: " + TextColor.reset + "\n"
                                        + "1. Enter Card Number" + "\n"
                                        + "2. Go Back";

    private final Scanner scan = new Scanner(System.in); 
    private Bank bank; 
    private ATM atm;
    private UserInputHandler inputHandler; 
    
    public CardVerificationState(UserInputHandler inputHandler, Bank bank, ATM atm) {
        this.inputHandler = inputHandler; 
        this.bank = bank; 
        this.atm = atm;
    }
    
    @Override 
    public void display() { 
        System.out.print(displayMessage);
    }
    
    @Override 
    public boolean askForInput() {
        this.display();
        String text = scan.nextLine();
        
        if (!this.isNumeric(text)) {
            System.out.println("\nPlease Enter a Number!"); 
            return true; 
        } 
        int option = Integer.parseInt(text);  
        if (option == 2) { 
            this.inputHandler.setState(new DefaultState(inputHandler, bank, atm));  
            return true; 
        }
        
        System.out.print("\n\n\nPlease Enter a Card Number: ");
        text = scan.nextLine();
        
        if (!this.isNumeric(text)) {
            System.out.println("\nPlease Enter a Number!"); 
            return true; 
        } 
        int cardNumber = Integer.parseInt(text); 
        boolean success = atm.insertCard(cardNumber); 
        
        if (!success) { 
            return true;
        }
        
        if (!atm.checkStatus()) {
            atm.ejectCard();
            System.out.println(TextColor.red + "\n\nEjecting Card" + TextColor.reset);
            return true;
        }
        
        int count = 0; 
        do { 
            System.out.print("\n\n\nPlease Insert Pin: "); 
            text = scan.nextLine();
            count ++; 
            
            
            if (atm.enterPin(text)) 
                break;
        } while (count < 3); 
        
        if (count >= 3) {  
            System.out.println(TextColor.red + "\n\nThe System Only Allowed 3 Attempts!"); 
            System.out.println("Ejecting Card!" + TextColor.reset);
            atm.ejectCard();
            return true; 
        }
        
        this.inputHandler.setState(new TransactionState(inputHandler, bank, atm));
        return true;    
    }

    private boolean isNumeric(String text) {  
        try { 
            int input = Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) { 
            return false;
        }
    }

}