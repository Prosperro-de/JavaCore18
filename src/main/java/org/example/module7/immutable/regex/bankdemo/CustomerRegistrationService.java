package org.example.module7.immutable.regex.bankdemo;

import java.util.Scanner;

public class CustomerRegistrationService {
    private static final String EMAIL_REGEX = "[a-z0-9]+@[a-z]{1,10}\\.[a-z]{2,6}";
    private static final String PASSWORD_REGEX = "(?=.*\\d)\\w{8,}";
    private Scanner scanner;

    public CustomerRegistrationService() {
        this.scanner = new Scanner(System.in);
    }

    public Customer registerCustomer() {
        String email = null;
        String password = null;
        try {
            System.out.println("Please enter email");
            email = scanner.nextLine();
            if (!email.matches(EMAIL_REGEX)) {
                throw new RegistrationValidationException("Please enter valid email");
            }
            System.out.println("Please enter password");
            password = scanner.nextLine();
            if (!password.matches(PASSWORD_REGEX)) {
                throw new RegistrationValidationException("Password should be min 8 length and contain at least 1 digit");
            }
        } catch (RegistrationValidationException ex ) {
            System.out.println(ex.getMessage());
            registerCustomer();
        }

        return new Customer(email, password);
    }
}
