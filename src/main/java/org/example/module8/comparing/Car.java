package org.example.module8.comparing;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Car implements Comparable<Car> {
    private String name;
    private int horsePower;

    @Override
    public int compareTo(Car o) {
        if (horsePower > o.horsePower) {
            return 1;
        } else if (horsePower < o.horsePower) {
            return -1;
        } else {
            return 0;
        }
    }

//    @Override
//    public int compareTo(Car o) {
//        if (name.compareTo(o.getName()) > 0) {
//            return 1;
//        } else if (name.compareTo(o.getName()) < 0) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
}
