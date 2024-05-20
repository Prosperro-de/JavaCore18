package org.example.module8;

public class PdfPage extends BasePage implements Printable {
    @Override
    public void print() {
        System.out.println("Printing PDF page");
    }

    public void convertPdfToWord() {

    }
}
