package Project3;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static Scanner userIn = new Scanner(System.in);
    private static Bank myBank = new Bank();
   public static void runMenu() throws NumberFormatException {
       //variables
       int menuNum = 0;
       int custPin;
       int initDeposit;
       int accNum;
       int PIN;
       String firstName;
       String lastName;
       String newCust;
       while (menuNum != 4) {
               //menu display
               System.out.println("**********MENU**********\n");
               System.out.println("1: Access an account.");
               System.out.println("2: Open a new account.");
               System.out.println("3: Close all accounts.");
               System.out.println("4: Exit");
           try {
               menuNum = Integer.parseInt(userIn.nextLine());
           } catch (NumberFormatException e) {
               System.err.println("Input Type Mismatch");
           }
               if (menuNum == 1) {
                       //access the account
                       System.out.println("Please enter your PIN.");
                       custPin = Integer.parseInt(userIn.nextLine());
                       Customer accCustomer = myBank.getCustomer(custPin);
                       if (accCustomer == null) {
                           System.out.println("PIN not valid.");
                       } else {
                           System.out.println(accCustomer.getAllAccounts());
                           System.out.println("Select an account. (By its account number)");
                           accNum = Integer.parseInt(userIn.nextLine());
                           while (menuNum != 5) {
                           if (accCustomer.getAccount(accNum) == null) {
                               System.out.println("Account number inavlid");
                               break;
                           }else {
                               Account isAccount = accCustomer.getAccount(accNum);
                               System.out.println("*****Accounts*****");
                               System.out.println("1) Make a deposit.");
                               System.out.println("2) Make a withdrawal.");
                               System.out.println("3) See account balance.");
                               System.out.println("4) Close Account");
                               System.out.println("5) Exit");
                               menuNum = Integer.parseInt(userIn.nextLine());
                               if (menuNum == 1) {
                                   //make a deposit
                                   System.out.println("Enter how much you would like to deposit.");
                                   int userDeposit = Integer.parseInt(userIn.nextLine());
                                   isAccount.makeDeposit(userDeposit);
                               }
                               if (menuNum == 2) {
                                   //Make a withdrawal
                                   System.out.println("How much are you withdrawing?");
                                   int userWithdrawal = Integer.parseInt(userIn.nextLine());
                                    isAccount.makeWithdrawal(userWithdrawal);
                               }
                               if (menuNum == 3) {
                                   System.out.printf("Account balance: %s\n", isAccount.getAccBalance());
                               }
                               if (menuNum == 4) {
                                   accCustomer.removeAccount(isAccount);
                                   System.out.println("Account Closed.");
                                   menuNum = 5;
                                                                  }
                               if (menuNum == 5) {
                                   break;
                               }
                           }
                       }
                   }
               } else if (menuNum == 2) {
                   //open the account
                   //check if the customer is new or returning
                   System.out.println("Are you a new customer?");
                   //get input
                   newCust = userIn.nextLine();
                   //force input to uppercase and check if yes or no
                   newCust = newCust.toUpperCase();
                   if (newCust.startsWith("Y")) {
                       //Get info for new customer and store info in variable
                       System.out.println("Please enter your first name.");
                       firstName = userIn.nextLine();
                       System.out.println("Please enter your last name.");
                       lastName = userIn.nextLine();
                       System.out.println("Create your new PIN (Digits). Save your PIN for account access");
                       PIN = Integer.parseInt(userIn.nextLine());
                       //create a new customer
                       createNewCustomer(firstName, lastName, PIN);
                       System.out.printf("\nWelcome to our bank, %s %s\n", firstName, lastName);
                       //Ask the customer to enter initial deposit.
                       System.out.println("Please enter an initial deposit");
                       initDeposit = Integer.parseInt(userIn.nextLine());
                       //create new account with that initial deposit
                       Account newAccount = new Account(initDeposit);
                       //call the customer method to add this account to the customer
                       myBank.getCustomer(PIN).addAccount(newAccount);
                       System.out.println("New account opened.\nAccount#: " + newAccount.getAccNumber());
                       PIN = 0;
                   } else if (newCust.startsWith("N")){
                       //gets returning customer
                       System.out.println("Please enter your PIN.");
                       PIN = Integer.parseInt(userIn.nextLine());
                       if (myBank.getCustomer(PIN) == null) {
                           System.out.println("No customer found");
                       }else {
                           //Ask the customer to enter initial deposit.
                           System.out.println("Please enter an initial deposit");
                           initDeposit = Integer.parseInt(userIn.nextLine());
                           //create new account with that initial deposit
                           Account newAccount = new Account(initDeposit);
                           //call the customer method to add this account to the customer
                           myBank.getCustomer(PIN).addAccount(newAccount);
                           System.out.println("New account opened.\nAccount#: " + newAccount.getAccNumber());
                           PIN = 0;
                       }
                   } else {
                       System.out.println("Invalid Entry. Returning to main Menu");
                   }

               } else if (menuNum == 3) {
                   System.out.println("Please enter your PIN to delete all of your accounts");
                   int tempPIN = Integer.parseInt(userIn.nextLine());
                   if (myBank.getCustomer(tempPIN) == null) {
                       System.out.println("No customer found");
                   }else {
                       myBank.deleteCustomer(myBank.getCustomer(tempPIN));
                       System.out.println("You have been removed from our registry.\nWe're sorry to see you go. ");
                   }
               } else if (menuNum == 4) {
                   System.out.println("Have a nice day! Come back soon.");
                   break;
               } else {
                   System.err.println("Invalid Input.");
               }
       }
       userIn.close();
   }
   private static Customer createNewCustomer(String firstName, String lastName, int PIN) {
       Customer newCustomer = new Customer(firstName, lastName, PIN);
       myBank.addNewCustomer(newCustomer);
       return newCustomer;
   }
}
