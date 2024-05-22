package org.example.module8.comparing;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getName().compareTo(o2.getName()) > 0) {
            return 1;
        } else if (o1.getName().compareTo(o2.getName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }


//    @Override
//    public int compare(Student o1, Student o2) {
//        return o1.getName().compareTo(o2.getName());
//    }
}
