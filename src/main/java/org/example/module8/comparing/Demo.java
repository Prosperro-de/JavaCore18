package org.example.module8.comparing;

import java.util.Arrays;
import java.util.Comparator;

public class Demo {
    public static void main(String[] args) {
        int[] intArray = {435, 12, 14, 432, 22, 563, 2};
        String[] stringArray = {"g", "d", "b", "t", "a", "n"};
        Car[] carArray = generateCars();
        Student[] studentsSortedByName = generateStudents();
        Student[] studentsSortedByGrade = generateStudents();

        StudentNameComparator studentNameComparator = new StudentNameComparator();
        StudentGradeComparator studentGradeComparator = new StudentGradeComparator();

        bubbleSort(intArray);
        Arrays.sort(stringArray);
        Arrays.sort(carArray);
        Arrays.sort(studentsSortedByName, studentNameComparator);
        Arrays.sort(studentsSortedByGrade, studentGradeComparator);

        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(stringArray));
        System.out.println(Arrays.toString(carArray));
        System.out.println(Arrays.toString(studentsSortedByName));
        System.out.println(Arrays.toString(studentsSortedByGrade));
    }

    public static Student[] generateStudents() {
        Student oleg = new Student("Oleg", 85);
        Student mykola = new Student("Mykola", 75);
        Student natalia = new Student("Natalia", 97);
        return new Student[]{oleg, mykola, natalia};
    }

    public static Car[] generateCars() {
        Car toyota = new Car("Toyota", 170);
        Car audi = new Car("Audi", 260);
        Car bmw = new Car("BMW", 265);
        return new Car[]{bmw, audi, toyota};
    }

    public static void bubbleSort(int[] arr) {
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;

                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
            }
        }
    }
}
