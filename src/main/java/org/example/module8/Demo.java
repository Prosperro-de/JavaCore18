package org.example.module8;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        PdfPage pdfPage = new PdfPage();
//        pdfPage.convertPdfToWord();
//        pdfPage.print();
//        pdfPage.buildPage();
        pdfPage.print();

        System.out.println("___________________");

        EmailPage emailPage = new EmailPage();
        emailPage.print();
        emailPage.send();
        emailPage.write();
        emailPage.buildPage();

        Printer printer = new Printer();
//        printer.printPdf(pdfPage);
//        printer.printEmail(emailPage);
        printer.printDoc(pdfPage);
        printer.printDoc(emailPage);
//        Comparable
//        Comparator
    }

}

class Printer {
//    void printPdf(PdfPage pdfPage) {
//        pdfPage.print();
//    }
//
//    void printEmail(EmailPage emailPage) {
//        emailPage.print();
//    }

    void printDoc(Printable printable) {
        printable.print();
        printable.buildPage();
    }
}
