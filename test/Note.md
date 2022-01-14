## Sequence of Operation 

A customer would first need to register an account (CustomerAccount) with our bank,
before he/she could open a bank account (ChequeAccount). 

Note: 
A **Customer** could have many **bank accounts** that are used for different purposes, and
some of those accounts are also link to some bank cards. 

**Customer** 
Has: 
    - List of Bank Accounts  
    - List of Bank Cards

Ex of Bank Accounts: 
1. Personal Account
2. Business Account 
3. Saving Account 

By having access to a CustomerAccount, we have access to all his/her: 
1. Bank Accounts 
2. Cards 