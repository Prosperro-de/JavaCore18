package org.example.module10.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

//        Customer customer = new Customer("Mykola", 33);
//        String customerJson = gson.toJson(customer);
//        System.out.println("customerJson = " + customerJson);

        Customer customer = Customer.builder()
                .name("Mykola")
                .age(33)
                .accountStatus(new BigDecimal("100.5"))
                .addresses(List.of(
                        Address.builder()
                                .city("Lviv")
                                .street("Horodotska")
                                .postCode(90000)
                                .build(),
                        Address.builder()
                                .city("Dnipro")
                                .street("Shevchenka")
                                .postCode(49000)
                                .build()
                ))
                .additionalInfo(
                        Map.of("TimeInService", "10000", "TypeOfClient", "Premium")
                )
                .build();
        String customerJson = gson.toJson(customer);
        System.out.println(customerJson);

        String anotherCustomerJson = """
                {
                  "name": "Oleg",
                  "age": 24,
                  "accountStatus": 150.5,
                  "addresses": [
                    {
                      "city": "Lviv",
                      "street": "Horodotska",
                      "postCode": 80000
                    },
                    {
                      "city": "Odesa",
                      "street": "Shevchenka",
                      "postCode": 20000
                    }
                  ],
                  "additionalInfo": {
                    "TimeInService": "10000",
                    "TypeOfClient": "Premium"
                  }
                }
                """;

        Customer anotherCustomer = gson.fromJson(anotherCustomerJson, Customer.class);
        System.out.println("anotherCustomer = " + anotherCustomer);


    }
}


