package org.example.module8;

public class EmailPage extends BasePage implements Printable, Sendable {
    public static final int MAX_PAGE_SIZE = 50;


    @Override
    public void print() {
        System.out.println("Print an email");
    }

    @Override
    public void send() {
        System.out.println("Sending an email");
    }

    @Override
    public void write() {
        System.out.println("Writing an email");
    }

    @Override
    public void buildPage() {
        System.out.println("Building a page with max size " + MAX_PAGE_SIZE);
    }
}
