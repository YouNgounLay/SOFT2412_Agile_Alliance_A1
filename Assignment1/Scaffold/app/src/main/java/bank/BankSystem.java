package bank;

import bank.UI.UserInputHandler;
import java.util.List; 
import java.util.ArrayList;

public class BankSystem {
	private Bank bank = new Bank();
        private UserInputHandler program = new UserInputHandler(bank, new ATM(bank));

	public BankSystem() {
		bank = new Bank();
		bank = this.sample1();
        program = new UserInputHandler(bank, new ATM(bank));
        program.askForInput();
	}

	public void run() {
		boolean run = true;
		while (run) {
        	run = program.askForInput();
		}
	}
	
	private Bank sample1() { 
		Bank newBank = new Bank(); 
		// Assuming that they alll have the same pin 
		String pin = "1111";
		Card phil = newBank.createNewCard("Phil", pin);
		phil.setStatus(false);
		newBank.createNewCard("Mia", pin);
		newBank.createNewCard("Marcus", pin);
		newBank.createNewCard("Ray", pin);
		newBank.createNewCard("Daniel", pin);
		
		return newBank;
	}

}
