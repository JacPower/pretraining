package org.example.solid.isp;

public class MultiFunctionPrinter implements Printer, ScannerDevice {
    @Override
    public void print() { System.out.println("Printing..."); }

    @Override
    public void scan() { System.out.println("Scanning..."); }
}
