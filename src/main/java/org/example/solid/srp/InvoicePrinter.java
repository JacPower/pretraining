package org.example.solid.srp;

public class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("Printing invoice for " + invoice.getCustomer()
                           + " Amount: " + invoice.getAmount());
    }
}
