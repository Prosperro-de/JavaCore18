package org.example.module8;

public interface Printable {
    int MAX_PAGE_SIZE = 100;

   void print();

   default void buildPage() {
       System.out.println("Building a page with max size " + 70);
   }

}
