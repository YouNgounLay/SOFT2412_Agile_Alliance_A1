package bank.UI; 

import bank.Bank; 
import bank.ATM;
import bank.UI.InputState.UserInputState;
import bank.UI.InputState.DefaultState; 

public class UserInputHandler { 
    private Bank bank; 
    private ATM atm;
    private UserInputState programState; 
    
    public UserInputHandler(Bank bank, ATM atm) { 
        this.bank = bank; 
        this.atm = atm; 
        this.programState = new DefaultState(this, bank, atm);
    }

    public boolean askForInput() {  
       return this.programState.askForInput();        
    }
    
    public void setState(UserInputState programState) { 
        this.programState = programState;
    }
}