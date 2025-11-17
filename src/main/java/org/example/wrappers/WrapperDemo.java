package org.example.wrappers;

import java.util.ArrayList;

public class WrapperDemo {

    public static void demonstrateWrappers() {
        demonstrateBasicWrappers();
        demonstrateAutoboxingUnboxing();
        demonstrateWrapperMethods();
        demonstrateParsingAndConversion();
        demonstrateWrappersInCollections();
    }



    private static void demonstrateBasicWrappers() {
        System.out.println("\n>>> Wrapper Classes:");

        // Primitive to Wrapper (Boxing)
        int primitiveInt = 10;
        Integer wrapperInt = Integer.valueOf(primitiveInt);

        double primitiveDouble = 3.14;
        Double wrapperDouble = Double.valueOf(primitiveDouble);

        boolean primitiveBoolean = true;
        Boolean wrapperBoolean = Boolean.valueOf(primitiveBoolean);

        char primitiveChar = 'A';
        Character wrapperChar = Character.valueOf(primitiveChar);

        System.out.println("Primitive int: " + primitiveInt + " → Wrapper Integer: " + wrapperInt);
        System.out.println("Primitive double: " + primitiveDouble + " → Wrapper Double: " + wrapperDouble);
        System.out.println("Primitive boolean: " + primitiveBoolean + " → Wrapper Boolean: " + wrapperBoolean);
        System.out.println("Primitive char: " + primitiveChar + " → Wrapper Character: " + wrapperChar);

        // Wrapper to Primitive (Unboxing)
        int extractedInt = wrapperInt.intValue();
        double extractedDouble = wrapperDouble.doubleValue();
        boolean extractedBoolean = wrapperBoolean.booleanValue();
        char extractedChar = wrapperChar.charValue();

        System.out.println("\nUnboxing:");
        System.out.println("Wrapper Integer: " + wrapperInt + " → Primitive int: " + extractedInt);
    }



    private static void demonstrateAutoboxingUnboxing() {
        System.out.println("\n>>> Autoboxing & Unboxing (Automatic Conversion):");

        // Autoboxing - automatic conversion from primitive to wrapper
        Integer autoBoxed = 100; // No need for Integer.valueOf()
        Double autoBoxedDouble = 99.99;
        Boolean autoBoxedBoolean = false;

        System.out.println("Autoboxed Integer: " + autoBoxed);
        System.out.println("Autoboxed Double: " + autoBoxedDouble);
        System.out.println("Autoboxed Boolean: " + autoBoxedBoolean);

        // Auto-unboxing - automatic conversion from wrapper to primitive
        int unboxed = autoBoxed; // No need for .intValue()
        double unboxedDouble = autoBoxedDouble;
        boolean unboxedBoolean = autoBoxedBoolean;

        System.out.println("\nAuto-unboxed int: " + unboxed);
        System.out.println("Auto-unboxed double: " + unboxedDouble);
        System.out.println("Auto-unboxed boolean: " + unboxedBoolean);

        // Autoboxing in expressions
        Integer result = 10 + 20; // Autoboxing the result
        System.out.println("\nAutoboxing in expression: " + result);
    }



    private static void demonstrateWrapperMethods() {
        System.out.println("\n>>> Useful Wrapper Methods:");

        // Integer methods
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Integer.compare(10, 20): " + Integer.compare(10, 20));
        System.out.println("Integer.sum(10, 20): " + Integer.sum(10, 20));

        // Double methods
        System.out.println("\nDouble.MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("Double.isNaN(0.0/0.0): " + Double.isNaN(0.0 / 0.0));
        System.out.println("Double.isInfinite(1.0/0.0): " + Double.isInfinite(1.0 / 0.0));

        // Character methods
        System.out.println("\nCharacter.isDigit('5'): " + Character.isDigit('5'));
        System.out.println("Character.isLetter('A'): " + Character.isLetter('A'));
        System.out.println("Character.isUpperCase('A'): " + Character.isUpperCase('A'));
        System.out.println("Character.toLowerCase('A'): " + Character.toLowerCase('A'));
        System.out.println("Character.toUpperCase('a'): " + Character.toUpperCase('a'));

        // Boolean methods
        System.out.println("\nBoolean.parseBoolean('true'): " + Boolean.parseBoolean("true"));
        System.out.println("Boolean.toString(true): " + true);
    }



    private static void demonstrateParsingAndConversion() {
        System.out.println("\n>>> Parsing & Type Conversion:");

        // String to primitive/wrapper
        String numberString = "123";
        String doubleString = "45.67";
        String booleanString = "true";

        int parsedInt = Integer.parseInt(numberString);
        Integer parsedInteger = Integer.valueOf(numberString);
        double parsedDouble = Double.parseDouble(doubleString);
        boolean parsedBoolean = Boolean.parseBoolean(booleanString);

        System.out.println("String '123' → int: " + parsedInt);
        System.out.println("String '123' → Integer: " + parsedInteger);
        System.out.println("String '45.67' → double: " + parsedDouble);
        System.out.println("String 'true' → boolean: " + parsedBoolean);

        // Wrapper to String
        Integer number = 999;
        String numberToString = number.toString();
        String anotherWay = String.valueOf(number);

        System.out.println("\nInteger 999 → String: '" + numberToString + "'");
        System.out.println("Using String.valueOf(): '" + anotherWay + "'");

        // Binary, Octal, Hex conversions
        System.out.println("\n>>> Number System Conversions:");
        int decimal = 42;
        System.out.println("Decimal: " + decimal);
        System.out.println("Binary: " + Integer.toBinaryString(decimal));
        System.out.println("Octal: " + Integer.toOctalString(decimal));
        System.out.println("Hexadecimal: " + Integer.toHexString(decimal));

        // Parsing from different bases
        System.out.println("\nParsing from binary: " + Integer.parseInt("101010", 2));
        System.out.println("Parsing from hex: " + Integer.parseInt("2A", 16));
    }



    private static void demonstrateWrappersInCollections() {
        System.out.println("\n>>> Wrappers in Collections (Why We Need Them):");

        // Collections can only store objects, not primitives
        // This is why wrapper classes are essential
        ArrayList<Integer> numbers = new ArrayList<>();

        // Autoboxing allows us to add primitives
        numbers.add(10);  // Autoboxed to Integer
        numbers.add(20);
        numbers.add(30);

        System.out.println("ArrayList of Integers: " + numbers);

        // Auto-unboxing when retrieving
        int firstNumber = numbers.get(0); // Auto-unboxed to int
        System.out.println("First number (auto-unboxed): " + firstNumber);

        // Using wrapper methods with collections
        System.out.println("Sum of all numbers: " + numbers.stream().mapToInt(Integer::intValue).sum());
        System.out.println("Max number: " + numbers.stream().max(Integer::compare).orElse(0));

        // Demonstrating null handling (only wrappers can be null)
        ArrayList<Integer> listWithNull = new ArrayList<>();
        listWithNull.add(10);
        listWithNull.add(null); // Allowed with wrapper
        listWithNull.add(30);

        System.out.println("\nList with null: " + listWithNull);
        System.out.println("Note: Primitives cannot be null, but wrappers can!");
    }
}
