package org.example.module11.optional;

import org.example.module11.lambda.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CustomerDao {
    private List<Customer> dataSource;


    public CustomerDao() {
        this.dataSource = new ArrayList<>();
        dataSource.add(new Customer("Oleg", 32));
        dataSource.add(new Customer("Olga", 23));
        dataSource.add(new Customer("Petro", 43));
        dataSource.add(null);
        dataSource.add(new Customer("Mykola", 82));
    }

    public Optional<Customer> getById(int id) {
        Objects.checkIndex(id, dataSource.size());
        return Optional.ofNullable(dataSource.get(id));
    }

    public Optional<List<Customer>> getAll() {
        return Optional.of(dataSource);
    }

    public Customer getCustomerFromAnotherDb() {
        System.out.println("perform long call to another data source for 10 sec");
        return new Customer("Stepan", 39);
    }
}
