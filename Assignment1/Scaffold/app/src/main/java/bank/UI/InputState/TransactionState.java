package bank.UI.InputState;

import bank.Bank; 
import bank.ATM; 
import bank.UI.UserInputHandler; 
import bank.UI.TextColor; 
import bank.UI.InputState.UserInputState; 
import bank.UI.InputState.CardVerificationState;

import java.util.Scanner; 

public class TransactionState implements UserInputState { 
    private final String displayMessage = "\n\n\n" + TextColor.green + "Please Choose One of the Following: " + TextColor.reset
                                        + "\n\n" + "1. Deposit Cash" + "\n" 
                                        + "2. Withdraw Cash" + "\n"  
                                        + "3. Check Balance" + "\n" 
                                        + "4. Cancel"; 
    private Scanner scan = new Scanner(System.in); 
    private Bank bank; 
    private ATM atm; 
    private UserInputHandler inputHandler;

    public TransactionState(UserInputHandler inputHandler, Bank bank, ATM atm) { 
        this.inputHandler = inputHandler; 
        this.bank = bank; 
        this.atm = atm; 
    }

    @Override
    public void display() {
        System.out.println(displayMessage);
        System.out.print("Enter Your Input (1 -> 4): "); 
    }
    
    @Override 
    public boolean askForInput() { 
        this.display(); 
        String text = scan.nextLine(); 

        if (!this.isNumeric(text)) { 
            System.out.println("\n" + TextColor.red + "Please Enter a Number!" + TextColor.reset); 
            return true;
        }
        int option = Integer.parseInt(text); 
        
        if (option < 1 || option > 4) { 
            System.out.println("\n" + TextColor.red + "Please Enter a Number Between 1 -> 4" + TextColor.reset);
            return true; 
        } 

        if (option == 3) { 
            System.out.println("\nCurrent Balance is: " + atm.checkBalance()); 
            return true;
        } else if (option == 4) { 
            atm.ejectCard();
            System.out.println("\n\nEjecting Card");
            inputHandler.setState(new CardVerificationState(inputHandler, bank, atm)); 
            return true; 
        }

        System.out.print("Enter Amount: "); 
        text = scan.nextLine();

        if (!this.isNumeric(text)) { 
            System.out.println("\n" + TextColor.red + "Please Enter a Number!" + TextColor.reset); 
            return true;
        }
        int amount = Integer.parseInt(text); 
        
        if (amount < 0) { 
            System.out.println("\n" + TextColor.red + "Please Enter a Positive Number" + TextColor.reset);
            return true; 
        } 
        
         
        boolean success;
        if (option == 1) {
            success = atm.deposit(amount);
            atm.addFunds(amount);
        } else {
            success = atm.withdraw(amount);
            if (amount > atm.getFunds()) { 
                System.out.println(TextColor.red + "\n\nSorry, We don't have enough fund to complete your transaction" + TextColor.reset);
                return true;
            }
        }
        System.out.println("\n\n\n" + atm.printReceipt(option == 1 ? "Deposit" : "Withdraw", amount));

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

}