package org.example.module9.genericsort;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        Integer[] intArray = {435, 12, 14, 432, 22, 563, 2};
        String[] stringArray = {"g", "d", "b", "t", "a", "n"};
        Car[] cars = generateCars();
        SortUtil.bubbleSort(intArray);
        SortUtil.bubbleSort(stringArray);
        SortUtil.bubbleSort(cars);



        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(stringArray));
        System.out.println(Arrays.toString(cars));


        Cat cat = new Cat(10, "John");
        Dog dog = new Dog(24, "Bob");

        System.out.println("cat.compareTo(dog) = " + cat.compareTo(dog));
        AnimalComparator<Animal> animalAnimalComparator = new AnimalComparator<>();
        System.out.println("animalAnimalComparator.compare(cat, dog) = " + animalAnimalComparator.compare(cat, dog));


    }

    public static Car[] generateCars() {
        Car toyota = new Car("Toyota", 170);
        Car audi = new Car("Audi", 260);
        Car bmw = new Car("BMW", 265);
        return new Car[]{bmw, audi, toyota};
    }
}
