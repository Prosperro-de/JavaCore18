package org.example.module9.genericsort;

import lombok.Data;


public class Dog extends Animal {
    private String name;

    public Dog(int age, String name) {
        super(age);
        this.name = name;
    }
}
