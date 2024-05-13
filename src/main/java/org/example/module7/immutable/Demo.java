package org.example.module7.immutable;


import java.lang.reflect.Field;
import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Customer mykola = new Customer("Mykola", 32);
        System.out.println("mykola = " + mykola);

//        Class<?> mykolaClass = mykola.getClass();
//        Field age = mykolaClass.getField("name");
//        age.setAccessible(true);
//        age.set(mykola, "Oleg");

        System.out.println("mykola = " + mykola);
        CustomerRec olena = new CustomerRec("Olena", 22);

        Invoice invoice = new Invoice(1, BigDecimal.TEN, mykola);

        System.out.println("invoice = " + invoice);
//        mykola.setName("Stepan");
        invoice.getCustomer().setAge(22);
        System.out.println("invoice = " + invoice);
    }
}
