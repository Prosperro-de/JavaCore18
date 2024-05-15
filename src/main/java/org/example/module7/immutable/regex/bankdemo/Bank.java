package org.example.module7.immutable.regex.bankdemo;

public class Bank {
    private Customer[] customers;
    private int customerCount;

    public Bank() {
        this.customers = new Customer[10];
    }

    public void addCustomer(Customer customer) {
        customers[customerCount] = customer;
        customerCount++;
    }
}
