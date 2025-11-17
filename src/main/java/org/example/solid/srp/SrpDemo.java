package org.example.solid.srp;

public class SrpDemo {
    public static void show() {
        Invoice invoice = new Invoice("John Doe", 1200);
        new InvoicePrinter().print(invoice);
        new InvoiceSaver().saveToDatabase(invoice);
    }
}
