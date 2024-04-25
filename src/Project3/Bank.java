package Project3;

import java.util.ArrayList;

public class Bank {
    //instance variables
    private ArrayList<Customer> customerArrayList = new ArrayList<Customer>();

    //bank operations
    public void addNewCustomer(Customer newCustomer) {
        customerArrayList.add(newCustomer);
    }
    public void deleteCustomer(Customer customer){customerArrayList.remove(customer);}


    public Customer getCustomer(int PIN) {
        Customer foundCustomer = null;
        for (Customer customer : customerArrayList) {
            if (customer.getPIN() == PIN) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }
    public String getAllCustomers() {
        String allCustomers = "\n*****CUSTOMERS*****";
        for (Customer customers: customerArrayList) {
            allCustomers += "\nName:" + customers.getFirstName() + " " + customers.getLastName() + "\nPIN: " + customers.getPIN();
        }
        return allCustomers;
    }
}
