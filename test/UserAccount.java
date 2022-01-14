package test;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public interface UserAccount {
    String getName(); 
    Date getDOB(); 
}

class CustomerAccount implements UserAccount { 
    private String name;
    private Date dateOfBirth;
    private final List<ChequeAccount> accounts = new ArrayList<>();
    private final List<Card> cards = new ArrayList<>();
    
    public CustomerAccount(String name, String dateOfBirth) { 
        this.name = name;
        String[] date = dateOfBirth.split("/");
        int day = Integer.parseInt(date[0]), month = Integer.parseInt(date[1]), year=Integer.parseInt(date[2]);
        this.dateOfBirth = new Date();
    }

    public List<ChequeAccount> getAccount() {
        return this.accounts;
    }
    
    public String getName() { 
        return this.name;
    }
    
    public Date getDOB() {
        return this.dateOfBirth;
    }
    
    public CustomerAccount addAccount(ChequeAccount account) { 
        this.accounts.add(account);
        return this; 
    }

    public void addCard(Card card) { 
        this.cards.add(card); 
    }
    
    public void removeAccount(BankAccount account) {
        int index = accounts.indexOf(account);
        this.accounts.remove(index);
    }
}