package Project3;

import Lab10.Pokemon;
import Lab11.Student;

import java.util.ArrayList;

public class Customer {
    //instance variables
    private String firstName;
    private String lastName;
    private int PIN;
    private ArrayList<Account> accountArrayList = new ArrayList<Account>();
    //constructor
    public Customer(String firstName, String lastName, int PIN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PIN = PIN;

    }
    //account operations
    public void addAccount(Account newAccount) {
        accountArrayList.add(newAccount);
    }
    public void removeAccount(Account oldAccount) {accountArrayList.remove(oldAccount);}
    public Account getAccount(int accNum) {
        Account foundAccount = null;
        for(Account account : accountArrayList){
            if(account.getAccNumber() == (accNum)){
                foundAccount = account;
                break;
            }
        }
        return foundAccount;

    }
    public String getAllAccounts(){
        String allAccounts = "\n****ACCOUNTS****\n";
        for (Account account: accountArrayList) {
                allAccounts = allAccounts + "#:" + account.getAccNumber() + "\n" + "Balance: " + account.getAccBalance() + "\n";
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
