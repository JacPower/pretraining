package org.example.solid.srp;

public class InvoiceSaver {
    public void saveToDatabase(Invoice invoice) {
        System.out.println("Invoice saved for " + invoice.getCustomer());
    }
}
