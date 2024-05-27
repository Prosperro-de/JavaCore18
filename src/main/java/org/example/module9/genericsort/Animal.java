package org.example.module9.genericsort;

import lombok.Data;

@Data
public abstract class Animal implements Comparable<Animal> {
    protected int age;

    public Animal(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Animal o) {
        return Integer.compare(age, o.age);
    }
}
