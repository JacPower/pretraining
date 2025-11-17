package org.example.exceptions;

import java.io.IOException;
import java.io.StringWriter;

public class ExceptionDemo {

    public static void demonstrateExceptions() {
        demonstrateBasicTryCatch();
        demonstrateMultipleCatch();
        demonstrateFinallyBlock();
        demonstrateThrowsKeyword();
        demonstrateCustomExceptions();
        demonstrateTryWithResources();
    }



    private static void demonstrateBasicTryCatch() {
        System.out.println("\n>>> Basic Try-Catch:");

        try {
            int result = 10 / 0; // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("❌ Caught Exception: " + e.getMessage());
            System.out.println("Cannot divide by zero!");
        }

        System.out.println("✓ Program continues after exception handling");
    }



    private static void demonstrateMultipleCatch() {
        System.out.println("\n>>> Multiple Catch Blocks:");

        try {
            String str = null;
            System.out.println(str.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("❌ NullPointerException: String is null");
        } catch (Exception e) {
            System.out.println("❌ General Exception: " + e.getMessage());
        }

        // Multi-catch (Java 7+)
        System.out.println("\n>>> Multi-Catch Block:");
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("❌ Caught: " + e.getClass().getSimpleName());
        }
    }



    private static void demonstrateFinallyBlock() {
        System.out.println("\n>>> Finally Block:");

        try {
            System.out.println("Inside try block");
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Inside catch block");
        } finally {
            System.out.println("✓ Finally block always executes!");
        }

        System.out.println("\nWith exception:");
        try {
            System.out.println("Inside try block");
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Inside catch block: " + e.getMessage());
        } finally {
            System.out.println("✓ Finally block executes even after exception!");
        }
    }



    private static void demonstrateThrowsKeyword() {
        System.out.println("\n>>> Throws Keyword:");

        try {
            readFile("nonexistent.txt");
        } catch (IOException e) {
            System.out.println("❌ Caught IOException: " + e.getMessage());
        }
    }



    // Method that declares it throws an exception
    private static void readFile(String filename) throws IOException {
        System.out.println("Attempting to read file: " + filename);
        throw new IOException("File not found: " + filename);
    }



    private static void demonstrateCustomExceptions() {
        System.out.println("\n>>> Custom Exceptions:");

        // Test CustomException
        try {
            validateAge(15);
        } catch (CustomException e) {
            System.out.println("❌ " + e);
        }

        // Test InsufficientBalanceException
        try {
            withdraw(5000.00, 500.00);
        } catch (InsufficientBalanceException e) {
            System.out.println("❌ " + e);
        }

        // Test InvalidAgeException (Runtime)
        try {
            setAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("❌ InvalidAgeException: " + e.getMessage());
        }
    }



    // Method that throws custom exception
    private static void validateAge(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Age must be 18 or above", "AGE_001");
        }
        System.out.println("✓ Age validated: " + age);
    }



    // Method demonstrating InsufficientBalanceException
    private static void withdraw(double amount, double balance) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient funds: Amount-" + balance + " and amount-" + amount);
        }
        System.out.println("✓ Withdrawal successful: $" + amount);
    }



    // Method demonstrating runtime exception
    private static void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Age must be between 0 and 150");
        }
        System.out.println("✓ Age set: " + age);
    }



    private static void demonstrateTryWithResources() {
        System.out.println("\n>>> Try-With-Resources (Auto-close):");

        // Try-with-resources automatically closes resources
        try (StringWriter writer = new StringWriter()) {
            writer.write("Hello, Try-With-Resources!");
            System.out.println("✓ Written: " + writer);
            System.out.println("✓ Resource will be auto-closed");
        } catch (IOException e) {
            System.out.println("❌ IOException: " + e.getMessage());
        }

        System.out.println("✓ No need for explicit finally block to close resources!");
    }
}
