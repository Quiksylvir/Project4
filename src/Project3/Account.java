package Project3;

public class Account {
    private int accBalance;
    private int accNumber;
    private static int numOfAccounts = 1000;
    //constructor
    public Account(int initialDeposit) {
        numOfAccounts++;
        accBalance = initialDeposit;
        accNumber = numOfAccounts;
    }
    //operations
    public void makeDeposit(int deposit) {
        setAccBalance(deposit + getAccBalance());
        System.out.printf("Thank you for your deposit.\nAccount Balance: %s\n", getAccBalance());
    }
    public void makeWithdrawal(int withdrawal) {
        if (withdrawal > getAccBalance()) {
            System.out.println("You cannot withdraw more than is in your account");
            System.out.printf("Account balance: %s\n", getAccBalance());
        } else {
            setAccBalance(getAccBalance() - withdrawal);
            System.out.printf("Account balance: %s\n", getAccBalance());
        }

    }
    @Override
    public String toString() {
        return String.format("Account#: %s\nAccount Balance: %s", getAccNumber(), getAccBalance());
    }
//getters
    public int getAccBalance() {
        return accBalance;
    }

    public int getAccNumber() {
        return accNumber;
    }

//setters

    public void setAccBalance(int accBalance) {
        this.accBalance = accBalance;
    }

}
