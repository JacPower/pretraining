package org.example;


import org.example.abstraction.Car;
import org.example.collections.CollectionsDemo;
import org.example.concurrency.ConcurrencyDemo;
import org.example.dip.DipDemo;
import org.example.exceptions.ExceptionDemo;
import org.example.fileio.FileHandler;
import org.example.functional.LambdaDemo;
import org.example.inheritance.Dog;
import org.example.solid.isp.IspDemo;
import org.example.solid.lsp.LspDemo;
import org.example.solid.ocp.OcpDemo;
import org.example.solid.srp.SrpDemo;
import org.example.wrappers.WrapperDemo;

public class Main {

    public static void main(String[] args) {
        printHeader("JAVA OOP AND CORE CONCEPTS DEMONSTRATION");

        section(1, "COLLECTIONS FRAMEWORK");
        CollectionsDemo.demonstrateCollections();

        //section(2, "FILE HANDLING (JAVA I/O API)");
        //FileHandler.demonstrateFileOperations();

        section(3, "CONCURRENCY IN JAVA");
        ConcurrencyDemo.demonstrateConcurrency();

        section(4, "INHERITANCE (OOP)");
        demonstrateInheritance();

        section(5, "ABSTRACTION (OOP)");
        demonstrateAbstraction();

        section(6, "EXCEPTION HANDLING");
        ExceptionDemo.demonstrateExceptions();

        section(7, "WRAPPER CLASSES");
        WrapperDemo.demonstrateWrappers();

        section(8, "FUNCTIONAL INTERFACES & LAMBDA EXPRESSIONS");
        LambdaDemo.demonstrateLambdas();

        demonstrateSolidPrinciples();

        printFooter("ALL DEMONSTRATIONS COMPLETED!");
    }



    private static void printHeader(String title) {
        String line = "=".repeat(60);
        System.out.println(line);
        System.out.println(title);
        System.out.println(line);
    }



    private static void printFooter(String message) {
        String line = "=".repeat(60);
        System.out.println("\n" + line);
        System.out.println(message);
        System.out.println(line);
    }



    private static void section(int number, String title) {
        System.out.println("\n\n" + number + ". " + title);
        System.out.println("-".repeat(60));
    }




    private static void demonstrateInheritance() {
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        dog.displayInfo();
        dog.makeSound();
        dog.fetch();
    }



    private static void demonstrateAbstraction() {
        Car car = new Car("Toyota", "Camry", 2023);
        car.displayInfo();
        car.start();
        car.accelerate(60);
        car.stop();
    }

    public static void demonstrateSolidPrinciples() {
        printHeader("JAVA SOLID PRINCIPLES DEMONSTRATION");

        runSection(2, "Single Responsibility Principle (SRP)", SrpDemo::show);
        runSection(3, "Open/Closed Principle (OCP)", OcpDemo::show);
        runSection(4, "Liskov Substitution Principle (LSP)", LspDemo::show);
        runSection(5, "Interface Segregation Principle (ISP)", IspDemo::show);
        runSection(6, "Dependency Inversion Principle (DIP)", DipDemo::show);

        printFooter("ALL SOLID PRINCIPLE DEMONSTRATIONS COMPLETED!");
    }
    private static void runSection(int number, String title, Runnable demo) {
        System.out.println("\n\n" + number + ". " + title);
        System.out.println("-".repeat(60));
        demo.run();
    }
}
