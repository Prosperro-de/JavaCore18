package org.example.module9;

import java.util.List;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private int age;
    private List<String> addresses;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(addresses, student.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
