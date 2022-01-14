package test;  

public interface BankAccount {
    int getAccountNumber(); 
    double getBalance(); 
    int getPin(); 
}

class ChequeAccount implements BankAccount { 
    private int accountNumber;  
    private double balance;  
    private int pin; 
    
    public ChequeAccount(int accountNumber, int pin) { 
        this.accountNumber = accountNumber; 
        this.pin = pin;
        this.balance = 0;
    }
    
    @Override
    public int getAccountNumber() {
        return this.accountNumber;
    }
    
    @Override 
    public double getBalance() { 
        return this.balance;
    }
     
    @Override 
    public int getPin() { 
        return this.pin;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) 
            return false;
        this.balance -= amount; 
        return true;
    }
    
    public boolean deposit(double amount) { 
        if (amount < 0) 
            return false;
        this.balance += amount;
        return true;
    }
    
    public String toString() { 
        String msg = "\nAccount Number: " + this.accountNumber;
        msg += "\nCurrent Balance: " + this.balance; 
        msg += "\nPin Number: " + this.pin;
        return msg;
    }
}



