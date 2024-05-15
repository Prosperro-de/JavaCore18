package org.example.module7.immutable.regex.bankdemo;

public class Demo {
    public static void main(String[] args) {
        Bank bank = new Bank();
        CustomerRegistrationService customerRegistrationService = new CustomerRegistrationService();
        bank.addCustomer(customerRegistrationService.registerCustomer());
    }


}
