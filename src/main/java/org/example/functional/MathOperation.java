package org.example.functional;


@FunctionalInterface
public interface MathOperation {
    // Static methods are allowed
    static MathOperation getAddition() {
        return (a, b) -> a + b;
    }

    static MathOperation getMultiplication() {
        return (a, b) -> a * b;
    }

    // Single abstract method
    int operate(int a, int b);

    // Default methods are allowed (Java 8+)
    default void printOperation(String operationName, int a, int b, int result) {
        System.out.println(operationName + ": " + a + " and " + b + " = " + result);
    }
}


@FunctionalInterface
interface StringProcessor {
    String process(String input);
}


@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}


@FunctionalInterface
interface NumberChecker {
    boolean check(int number);
}
