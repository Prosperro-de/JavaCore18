package org.example.module11.optional;

import org.example.module11.lambda.Customer;

import java.util.Optional;
import java.util.function.Function;

public class Demo {
    public static void main(String[] args) {
//        Customer customer = new Customer("Mykola", 24);
//        System.out.println("customer.getAge() = " + customer.getAge());
//        Optional<Customer> customerOptional = Optional.of(customer);

        CustomerDao customerDao = new CustomerDao();
//        for (int i = 0; i < 5; i++) {
//            Optional<Customer> byId = customerDao.getById(i);
//            Customer customer = byId.orElse(new Customer("default name", 20));
//            System.out.println("customer = " + customer);
//            Customer customer = byId.orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
//            System.out.println("customer = " + customer);
//            if (byId.isPresent()) {
//                Customer customer = byId.get();
//                System.out.println("customer = " + customer);
//            }
//            byId.ifPresent(customer -> {
//                System.out.println(customer.getName());
//                System.out.println(customer.getAge());
//                System.out.println("_______________________");
//            });
//        }

//        customerDao.getAll().ifPresent(System.out::println);
        Optional<Customer> byId = customerDao.getById(1);

//        Customer customer = byId.orElse(customerDao.getCustomerFromAnotherDb());
        Customer customer = byId.orElseGet(customerDao::getCustomerFromAnotherDb);


        System.out.println("customer = " + customer);


    }
}
