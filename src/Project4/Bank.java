package Project4;

import java.util.LinkedList;

public class Bank {
    //instance variables
    private LinkedList<Customer> customerLinkedList = new LinkedList<Customer>();

    //bank operations
    public void addNewCustomer(Customer newCustomer) {
        customerLinkedList.add(newCustomer);
    }
    public void deleteCustomer(Customer customer){
        customerLinkedList.remove(customer);}


    public Customer getCustomer(int PIN) {
        Customer foundCustomer = null;
        for (Customer customer : customerLinkedList) {
            if (customer.getPIN() == PIN) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }
    public String getAllCustomers() {
        String allCustomers = "\n*****CUSTOMERS*****";
        for (Customer customers: customerLinkedList) {
            allCustomers += "\nName:" + customers.getFirstName() + " " + customers.getLastName() + "\nPIN: " + customers.getPIN();
        }
        return allCustomers;
    }
}
