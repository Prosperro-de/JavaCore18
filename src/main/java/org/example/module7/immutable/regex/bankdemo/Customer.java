package org.example.module7.immutable.regex.bankdemo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String email;
    private String password;
}
