package bank;

import java.time.LocalDate; 
import java.time.LocalDateTime;
import bank.Bank;

public class Card {

  private String name;
  private double balance;
  private int cardNumber;
  private String pin;
  private boolean status;
  private boolean valid;
  private LocalDate dateExpired;
  private LocalDate dateIssued;

  public Card(int cardNumber, String pin, String name) {
    this.cardNumber = cardNumber; 
    this.pin = pin;
    this.dateIssued = LocalDateTime.now().toLocalDate();
    this.dateExpired = LocalDateTime.now().toLocalDate().plusYears(3); 
    this.status = true;
    this.name = name;
    this.balance = 0;
  }
  
  public int getNumber() {
	  return this.cardNumber;
  }

  public double getBalance() {
    return this.balance;
  }

  public boolean getStatus(){
    return this.status;
  }

  public void setStatus(boolean status) { 
    this.status = status; 
  }

  public String getPin() { 
    return this.pin;
  }

  public boolean checkExpiry(){
    int monthNow = LocalDateTime.now().toLocalDate().getMonthValue();
    int yearNow = LocalDateTime.now().toLocalDate().getYear();

    if(yearNow < this.dateExpired.getYear()){
      return true;
    }
    else if(yearNow == this.dateExpired.getYear()){
      if(monthNow < this.dateExpired.getMonthValue()){
        return true;
      }
    }
    else{
      return false;
    }
    return false;
  }

  public boolean checkExpiryFutureTime(){
    int monthNow = LocalDateTime.now().toLocalDate().getMonthValue();
    int yearNow = LocalDateTime.now().toLocalDate().plusYears(4).getYear();

    if(yearNow < this.dateExpired.getYear()){
      return true;
    }
    else if(yearNow == this.dateExpired.getYear()){
      if(monthNow < this.dateExpired.getMonthValue()){
        return true;
      }
    }
    else{
      return false;
    }
    return false;
  }

  public boolean checkIssueDate(){
    int monthNow = LocalDateTime.now().toLocalDate().getMonthValue();
    int yearNow = LocalDateTime.now().toLocalDate().getYear();

    if(yearNow > this.dateIssued.getYear()){
      return true;
    }
    else if(yearNow == this.dateIssued.getYear()){
      if(monthNow <= this.dateExpired.getMonthValue()){
        return true;
      }
    } else{
      return false;
    }
    return false;
  }

  public boolean checkIssueDatePastTime(){
    int monthNow = LocalDateTime.now().toLocalDate().getMonthValue();
    int yearNow = LocalDateTime.now().toLocalDate().minusYears(1).getYear();

    if(yearNow > this.dateIssued.getYear()){
      return true;
    }
    else if(yearNow == this.dateIssued.getYear()){
      if(monthNow <= this.dateExpired.getMonthValue()){
        return true;
      }
    } else{
      return false;
    }
    return false;
  }

  public boolean withdraw(double amount) {
    if (this.balance < amount){
      return false;
    }
    this.balance -= amount;
    return true;
  }

  public boolean deposit(double amount) {
    this.balance += amount;
    return true;
  }
  
  public boolean isValid(){
    if(this.getStatus() == true){
      if(this.checkExpiry() == true){
        if(this.checkIssueDate() == true){
          this.valid = true;
          return this.valid;
        }
      }
    }
    this.valid = false;
    return this.valid;
  }
}
