clear 
javac UserAccount.java BankAccount.java Card.java ATM.java Program.java 

cd ..
java test/Program   
cd test

for file in *.class; do 
    rm $file 
done