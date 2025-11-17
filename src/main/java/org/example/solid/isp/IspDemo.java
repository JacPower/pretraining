package org.example.solid.isp;

public class IspDemo {
    public static void show() {
        Printer basic = new BasicPrinter();
        basic.print();

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print();
        mfp.scan();
    }
}
