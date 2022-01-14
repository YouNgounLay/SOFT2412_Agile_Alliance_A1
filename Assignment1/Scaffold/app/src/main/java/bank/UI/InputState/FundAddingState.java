package bank.UI.InputState; 

import bank.UI.TextColor; 
import bank.UI.UserInputHandler;
import bank.UI.InputState.UserInputState; 
import bank.ATM;
import bank.Bank; 

import java.util.Scanner; 

public class FundAddingState implements UserInputState {  
   private final String displayMessage = TextColor.cyan + "\n\n\nHow Much Would You Like to Add: " + TextColor.reset;   
   private Scanner scan = new Scanner(System.in);
   private UserInputHandler inputHandler;
   private Bank bank;
   private ATM atm; 

    public FundAddingState(UserInputHandler inputHandler, Bank bank, ATM atm) { 
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
            System.out.println(TextColor.red + "\nPlease Enter a Number!" + TextColor.reset);
            return true;
        }
        
        double amount = Double.parseDouble(text); 
        if (amount < 0) { 
            System.out.println(TextColor.red + "\nPlease Enter a Positive Amount!" + TextColor.reset); 
            return true;
        }
        
        this.atm.addFunds(amount); 
        this.inputHandler.setState(new DefaultState(inputHandler, bank, atm));
        return true;  
    }
    
    private boolean isNumeric(String text) {
        try { 
            double number = Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) { 
            return false; 
        }
    }
}