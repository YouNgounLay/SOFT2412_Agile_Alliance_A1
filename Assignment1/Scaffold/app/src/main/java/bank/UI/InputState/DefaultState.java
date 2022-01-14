package bank.UI.InputState;

import bank.Bank; 
import bank.ATM; 
import bank.UI.TextColor; 
import bank.UI.UserInputHandler; 
import bank.UI.InputState.*;

import java.util.Scanner; 

public class DefaultState implements UserInputState { 
    private final String welcomeMessage = TextColor.cyan + "\n\n\nWelcome To Agile Alliance Bank" + TextColor.reset; 
    private final String displayImage = TextColor.green + "\nPlease Select One of The Following Access Methods:" + TextColor.reset 
                                      + "\n" + "1. Insert Card" + "\n"
                                      + "2. Adding Available Fund" + "\n"
                                      + "3. Exit The Program" + "\n";
    private UserInputHandler inputHandler;
    private Bank bank; 
    private ATM atm; 
    private final Scanner scan = new Scanner(System.in);
    
    public DefaultState(UserInputHandler inputHandler, Bank bank, ATM atm) {
        this.inputHandler = inputHandler; 
        this.bank = bank; 
        this.atm = atm;
    }
    
    @Override
    public void display() {
        System.out.println(welcomeMessage);
        System.out.println(displayImage); 
        System.out.print("Enter Your Option (1-3): ");
    }
    
    @Override
    public boolean askForInput() { 
        this.display(); 
        String text = scan.nextLine();
        
        if (!this.isNumeric(text)) { 
            System.out.println("\nPlease Provide a Number");
            return true;
        } 
        
        int option = Integer.parseInt(text); 

        if (option <= 0 || option > 3) { 
            System.out.println("\nPlease Provide a Number Between 1 and 3");
            return true; 
        }
        
        switch (option) { 
            case 1:
                inputHandler.setState(new CardVerificationState(inputHandler, bank, atm)); 
                break; 
            case 2: 
                inputHandler.setState(new FundAddingState(inputHandler, bank, atm));
                break;
            case 3: 
                return false; 
        }
        return true;
    }
    
    private boolean isNumeric(String text) { 
        try { 
            int option = Integer.parseInt(text);
            return true; 
        } catch (NumberFormatException e) { 
            return false; 
        }
    }

    private String stringMul(String text, int count) {
        if (count <= 0) 
            return "";
        String newText = ""; 
        for (int i = 0; i < count; i++) 
            newText += text; 
        return newText;
    }
}
