package bank;

import bank.Bank;
import bank.Card; 
import bank.UI.TextColor;

import java.lang.Math;
import java.util.List; 
import java.util.ArrayList;


public class ATM {
	//private List<Card> cardList; //maybe take out
	private Card currentCard;
	private double availableFunds;
	private int transactionsCount;
	private List<Card> confiscatedCards;
	private Bank bank;

	public ATM(Bank bank) {
		this.bank = bank;
		this.confiscatedCards = new ArrayList<>();
		this.availableFunds = 0;
		this.currentCard = null;
		this.transactionsCount = 0;
	}

	public void addFunds(double funds) {
		if (funds < 0) {
			System.out.println("The ATM only accepts valid values. Please try again.");
			return;
		}
		this.availableFunds += funds;
		return;
	}
	
	public double getFunds() { 
		return this.availableFunds;
	}
	
	public Card getCurrentCard() { 
		return this.currentCard;
	}

	public List<Card> getConfiscatedCards() { 
		return this.confiscatedCards;
	}

	public boolean insertCard(int cardNumber) {

		if (cardNumber == 0) {
			System.out.println("The card number you've entered is invalid. Please enter a valid card number.");
			return false;
		}

		for (Card c : this.bank.getCardList()) {
			if (c.getNumber() == cardNumber) {
				currentCard = c;
			}
		}

		if (currentCard == null) {
			System.out.println("\n\nThe card number you've entered is invalid. Please enter a valid card number.");
			return false;
		} 
		return true;
	}

	public boolean checkStatus() {
		/* Card class needs to have a separate status check method */
		boolean status = currentCard.getStatus();
		if (!status) {
			this.confiscatedCards.add(this.currentCard);
			System.out.println("Sorry, it seems like there is a problem with your card. We will hold onto your card for now until you contact someone from our bank. We apologise for the inconvenience.");
			return false;
		}
		return true;
	}

	public boolean enterPin(String pin) {
		boolean success = (pin.equals(currentCard.getPin()));
		if (!success){
			System.out.print("Incorrect pin. Please enter the correct pin.");
		}
		return success;
	}


	public boolean deposit(int amount) {
		if (this.currentCard == null) {
			return false;
		}
		if (amount % 5 != 0) {
			System.out.println("The ATM only accepts Australian notes. No coins will be accepted. Please enter a suitable amount to deposit in cash only.");
			return false;
		}
		this.currentCard.deposit(amount);
		this.transactionsCount += 1;
		this.availableFunds += amount;
		this.printReceipt("Deposit", amount);
		return true;
	}

	public boolean withdraw(double amount) {
		if (this.currentCard == null) {
			return false;
		}
		if (this.availableFunds < amount) {
			System.out.println("ERROR: There are insufficient funds in the ATM. Your transaction has been cancelled. We apologise for the inconvenience.");
			return false;
		}
        /* for this to work Account withdraw() must have a boolean return type.
        I haven't included any error/success messages, in case Account/System wants to handle that.
         */
		boolean successful = this.currentCard.withdraw(amount);
		if (successful) {
			this.availableFunds = this.availableFunds - amount;
			this.transactionsCount += 1;
			this.printReceipt("Withdraw", amount);
			return true;
		}

		else{
			System.out.println("ERROR: There are insufficient funds in your account. Your transaction has been cancelled.");
			return false;
		}


	}

	public double checkBalance() {
		if (this.currentCard == null) 
			return -1;
		return this.currentCard.getBalance();
	}

	public String printReceipt(String transactionType, double amount) {

		String message = TextColor.cyan + "Transaction Number: %d\nSuccessfully %s $%.2f into your account.\nCurrent Balance is: $%.2f" + TextColor.reset; 
		double accountBalance = this.currentCard.getBalance();
		String placeHolder = transactionType.toLowerCase().equals("deposit") ? "Deposited" : "Withdrawn"; 

		return String.format(message, transactionsCount, placeHolder, amount, accountBalance); 
		
	}

	public void ejectCard() {
		this.currentCard = null;
	}

}

