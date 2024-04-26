package Project4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Customer implements Accounts{
    //instance variables
    private String firstName;
    private String lastName;
    private int PIN;
    private HashMap<Integer, Account> accountHashMap = new HashMap<Integer, Account>();
    private ArrayList<Savings> savingsArrayList = new ArrayList<>();
    //constructor
    public Customer(String firstName, String lastName, int PIN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PIN = PIN;

    }
    public Customer(){
    }
    //account operations
    //checking account
    @Override
    public void addAccount(Account newAccount) {
        accountHashMap.put(newAccount.getAccNumber(),newAccount);
    }
    @Override
    public void removeAccount(Integer oldAccount) {
        accountHashMap.remove(oldAccount);}

    //savings account
    public void addSavings(Savings newAccount) { savingsArrayList.add(newAccount);}
    public void removeSavings(Savings oldAccount){savingsArrayList.remove(oldAccount);}

    public Savings getSavings(int accNum) {
        Savings foundAccount = null;
        for (Savings savings: savingsArrayList) {
            if (savings.getAccNumber() == accNum) {
                foundAccount = savings;
                return foundAccount;
            }
        }
        return foundAccount;
    }
    public Account getAccount(int accNum) {
        Account foundAccount = null;
        if (accountHashMap.get(accNum) != null) {
            foundAccount = accountHashMap.get(accNum);
        }
        return foundAccount;

    }
    public String getAllCheckingAccounts() {
        AtomicReference<String> allAccounts = new AtomicReference<>("\n****CHECKING ACCOUNTS****\n");
            accountHashMap.forEach((key, value) -> allAccounts.updateAndGet(v -> v + (value) + "\n"));
        return allAccounts.get();
    }
    public String getAllSavingsAccounts() throws IOException {
        String allAccounts = "\n****SAVING ACCOUNTS****\n";
        for (Savings saving: savingsArrayList) {
            allAccounts += "Account#: " + saving.getAccNumber() + "\nAccount Balance: " + saving.getAccBalance() +"\n";
        }
        return allAccounts;
    }
    @Override
    public String toString() {
        return String.format("Customer: %s %s\nPIN: %s", getFirstName(),getLastName(),getPIN());
    }
    //getters
    public int getPIN() {
        return PIN;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
