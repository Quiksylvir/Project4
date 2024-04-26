package Project4;

import java.io.IOException;
import java.util.Scanner;

public class Savings extends Account{
    //instance variables
    private int withdrawalLimit = 1;

    //constructor
    public Savings(int initialDeposit) throws IOException {
        super(initialDeposit);
    }

    @Override
    public void makeWithdrawal(int withdrawal) throws IOException {
        if (withdrawalLimit != 0) {
            super.makeWithdrawal(withdrawal);
            withdrawalLimit--;
        }else {
            System.out.println("Your withdrawal limit has been reached. Please try again another day.");
        }
    }
}
