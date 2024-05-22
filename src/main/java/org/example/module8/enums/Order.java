package org.example.module8.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private String name;
    private ProductType productType; // premium or standard
    private OrderStatus orderStatus; // created or in progress
}
