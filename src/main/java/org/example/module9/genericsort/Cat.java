package org.example.module9.genericsort;

import lombok.Data;


public class Cat extends Animal {
    private String color;

    public Cat(int age, String color) {
        super(age);
        this.color = color;
    }
}
