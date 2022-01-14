# SOFT2412---AGILE-ALLIANCE

### Collaborators: 

| Name          | Uni Key   | Email                      |
|:--------------|:----------|:---------------------------|
| Philip Law    | plaw9786  | plaw9785@uni.sydney.edu.au |
| Marcus Peters | mpet0303  | mpet0303@uni.sydney.edu.au |
| Ray Saha      | rsah8624  | rsah8624@uni.sydney.edu.au |
| Mia Bodycomb  | mbod4097  | mbod4097@uni.sydney.edu.au |
| Daniel Lay    | ylay3633  | ylay3633@uni.sydney.edu.au |

## The Agile Alliance ATM 

### Introduction: 

Welcome to the Agile Alliance Bank, we are proudly to represent you our new ATM program that offers the following functionality: 

1. Adding Funds to the ATM machine to allows other user to withdraw from the ATM.  
2. Allows the user to enter his/her card number and the system then check if the provided card number existed in the system 
3. After the card is verified, the machine then asked the user to enter the pin number in order to access to his/her account 

**Note:** The user could only attempt to enter their pin 3 times, if all attempts are used, the card is automatically ejected 

4. After the corrected pin number is provided, the user then could, deposit cash to his/her, withdraw cash if the ATM has available funds, check his/her balanace, and cancel the operation.  

#### Running the Program: 

To run the program please run the following command in your bash terminal under this directory: 

	bash run.sh

We have created a sample set of cards with the same pin numbers of 1111: 

1. Phil (10000): A confiscated Card 
2. Mia (10001): A Normal Card 
3. Ray (10002): A Normal Card 
4. Daniel(10003): A Normal Card

#### Testing The Program:  

Our team has done extensive testing on our each of our classes (ATM, Bank, Card). If you would like to do further testing, please following the following path: Assignment1/Scaffold/src/test/java/test and test to your heart desire. 

To run the test with JacocoReport, please run: 

	bash run_test.sh 
	
To run the test with JacocoReport, please run:  
	
	bash run_jacoco_test.sh

