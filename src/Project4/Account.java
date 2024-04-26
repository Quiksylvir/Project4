package Project4;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Account {
    private int accBalance;
    private int accNumber;
    private static int numOfAccounts = 1000;
    //constructor
    public Account(int initialDeposit) throws IOException {
        numOfAccounts++;
        accNumber = numOfAccounts;
        fileWrite(initialDeposit);
    }
    //operations
    public void makeDeposit(int deposit) throws IOException {
            fileWrite(deposit);
        /*
        setAccBalance(deposit + getAccBalance());
        System.out.printf("Thank you for your deposit.\nAccount Balance: %s\n", getAccBalance());
        */
        //file deposit amount
    }
    public void makeWithdrawal(int withdrawal) throws IOException {
        if (withdrawal > getAccBalance()) {
            System.out.println("You cannot withdraw more than is in your account");
            System.out.printf("Account balance: %s\n", getAccBalance());
        } else {
            fileWrite(-withdrawal);
            System.out.printf("Account balance: %s\n", getAccBalance());
        }

    }
    @Override
    public String toString() {
        try {
            return String.format("Account#: %s\nAccount Balance: %s", getAccNumber(), getAccBalance());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//getters
    public int getAccBalance() throws IOException {
        return Integer.parseInt(fileRead());
    }

    public int getAccNumber() {
        return accNumber;
    }

    //file manipulation

    //read
    public String fileRead() throws IOException {
        String readBalance;
        //open file
        try {
            FileInputStream fInStream = new FileInputStream(Integer.toString(accNumber));
            //scanner created with file stream
            Scanner fileIn = new Scanner(fInStream);
            //prints line from file
            try {
                readBalance = fileIn.nextLine();
                fInStream.close();
                return readBalance;
            } catch (NoSuchElementException e) {
                fInStream.close();
                return "0";
            }
        } catch (FileNotFoundException e) {
            //open file
            FileWriter fWrite = new FileWriter(Integer.toString(accNumber), false);
            PrintWriter outFS = new PrintWriter(fWrite);
            //print to file
            outFS.println(0);
            return "0";
        }
    }

    //append to file
    public void fileWrite(int deposit) throws IOException {
        //add deposit to existing balance
        String readBal = fileRead();
        deposit += Integer.parseInt(readBal);
        //open file
        FileWriter fWrite = new FileWriter(Integer.toString(accNumber), false);
        PrintWriter outFS = new PrintWriter(fWrite);
        //print to file
            outFS.println(deposit);
        //close writer
        fWrite.close();
        outFS.close();
    }
    public void fileDelete() {
        File myFile = new File(Integer.toString(accNumber));
        if (myFile.delete()) {
            System.out.println("Deleted account#: " + myFile.getName());
        } else {
            System.out.println("Failed to delete the Account.");
        }
    }
}
