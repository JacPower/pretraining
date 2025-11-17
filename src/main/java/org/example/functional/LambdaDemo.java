package org.example.functional;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class LambdaDemo {

    public static void demonstrateLambdas() {
        demonstrateBasicLambda();
        demonstrateBuiltInFunctionalInterfaces();
        demonstrateMethodReferences();
        demonstrateStreamAPI();
    }



    private static void demonstrateBasicLambda() {
        System.out.println("\n>>> Custom Functional Interfaces with Lambda:");

        // Traditional way (before Java 8)
        MathOperation addition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Traditional way - Addition: " + addition.operate(10, 5));

        // Lambda expression way
        MathOperation addLambda = (a, b) -> a + b;
        MathOperation subtractLambda = (a, b) -> a - b;
        MathOperation multiplyLambda = (a, b) -> a * b;
        MathOperation divideLambda = (a, b) -> b != 0 ? a / b : 0;

        System.out.println("\nLambda expressions:");
        addLambda.printOperation("Addition", 10, 5, addLambda.operate(10, 5));
        subtractLambda.printOperation("Subtraction", 10, 5, subtractLambda.operate(10, 5));
        multiplyLambda.printOperation("Multiplication", 10, 5, multiplyLambda.operate(10, 5));
        divideLambda.printOperation("Division", 10, 5, divideLambda.operate(10, 5));

        // Using static factory methods
        MathOperation add = MathOperation.getAddition();
        System.out.println("\nUsing static factory: " + add.operate(20, 30));

        // StringProcessor lambda
        StringProcessor toUpperCase = str -> str.toUpperCase();
        StringProcessor toLowerCase = str -> str.toLowerCase();
        StringProcessor addPrefix = str -> "Hello, " + str + "!";

        System.out.println("\nString Processing:");
        System.out.println(toUpperCase.process("java"));
        System.out.println(toLowerCase.process("LAMBDA"));
        System.out.println(addPrefix.process("World"));

        // Greeting lambda
        Greeting greeting = name -> System.out.println("Hello, " + name + "!");
        System.out.println("\nGreeting:");
        greeting.sayHello("Gitau");

        // NumberChecker lambda (predicate)
        NumberChecker isEven = n -> n % 2 == 0;
        NumberChecker isPositive = n -> n > 0;
        NumberChecker isGreaterThan10 = n -> n > 10;

        System.out.println("\nNumber Checking:");
        System.out.println("Is 8 even? " + isEven.check(8));
        System.out.println("Is 15 even? " + isEven.check(15));
        System.out.println("Is -5 positive? " + isPositive.check(-5));
        System.out.println("Is 20 greater than 10? " + isGreaterThan10.check(20));
    }



    private static void demonstrateBuiltInFunctionalInterfaces() {
        System.out.println("\n>>> Built-in Functional Interfaces (java.util.function):");

        // Predicate<T> - takes argument, returns boolean
        System.out.println("\n1. Predicate<T>:");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<String> isEmpty = str -> str.isEmpty();
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println("Is 10 even? " + isEven.test(10));
        System.out.println("Is 7 even? " + isEven.test(7));
        System.out.println("Is '' empty? " + isEmpty.test(""));

        // Combining predicates
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        System.out.println("Is 10 even AND positive? " + isEvenAndPositive.test(10));
        System.out.println("Is -10 even AND positive? " + isEvenAndPositive.test(-10));

        // Function<T, R> - takes argument of type T, returns type R
        System.out.println("\n2. Function<T, R>:");
        Function<String, Integer> stringLength = str -> str.length();
        Function<Integer, Integer> square = n -> n * n;
        Function<Integer, String> intToString = n -> "Number: " + n;

        System.out.println("Length of 'Lambda': " + stringLength.apply("Lambda"));
        System.out.println("Square of 5: " + square.apply(5));
        System.out.println(intToString.apply(42));

        // Chaining functions
        Function<Integer, Integer> addTen = n -> n + 10;
        Function<Integer, Integer> multiplyByTwo = n -> n * 2;
        Function<Integer, Integer> combined = addTen.andThen(multiplyByTwo);
        System.out.println("(5 + 10) * 2 = " + combined.apply(5));

        // Consumer<T> - takes argument, returns nothing
        System.out.println("\n3. Consumer<T>:");
        Consumer<String> printUpper = str -> System.out.println(str.toUpperCase());
        Consumer<Integer> printSquare = n -> System.out.println("Square: " + (n * n));

        printUpper.accept("hello consumer");
        printSquare.accept(6);

        // Chaining consumers
        Consumer<String> print = str -> System.out.print(str);
        Consumer<String> println = str -> System.out.println(" - processed");
        Consumer<String> combinedConsumer = print.andThen(println);
        combinedConsumer.accept("Lambda Expression");

        // Supplier<T> - takes no argument, returns value
        System.out.println("\n4. Supplier<T>:");
        Supplier<String> randomGreeting = () -> "Hello from Supplier!";
        Supplier<Double> randomNumber = () -> Math.random();
        Supplier<Integer> getCurrentYear = () -> 2025;

        System.out.println(randomGreeting.get());
        System.out.println("Random: " + randomNumber.get());
        System.out.println("Year: " + getCurrentYear.get());

        // BiFunction<T, U, R> - takes two arguments, returns value
        System.out.println("\n5. BiFunction<T, U, R>:");
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<String, String, String> concat = (s1, s2) -> s1 + " " + s2;

        System.out.println("Add 10 + 20 = " + add.apply(10, 20));
        System.out.println("Concat: " + concat.apply("Hello", "World"));

        // UnaryOperator<T> - special case of Function<T, T>
        System.out.println("\n6. UnaryOperator<T>:");
        UnaryOperator<Integer> doubleIt = n -> n * 2;
        UnaryOperator<String> addExclamation = str -> str + "!";

        System.out.println("Double 15: " + doubleIt.apply(15));
        System.out.println(addExclamation.apply("Awesome"));

        // BinaryOperator<T> - special case of BiFunction<T, T, T>
        System.out.println("\n7. BinaryOperator<T>:");
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        BinaryOperator<String> concatenate = (s1, s2) -> s1 + s2;

        System.out.println("Multiply 5 * 6 = " + multiply.apply(5, 6));
        System.out.println("Concatenate: " + concatenate.apply("Java", "Lambda"));
    }



    private static void demonstrateMethodReferences() {
        System.out.println("\n>>> Method References:");

        // Static method reference
        Function<String, Integer> parseIntLambda = s -> Integer.parseInt(s);
        Function<String, Integer> parseIntMethodRef = Integer::parseInt;

        System.out.println("Lambda: " + parseIntLambda.apply("123"));
        System.out.println("Method Reference: " + parseIntMethodRef.apply("456"));

        // Instance method reference
        String prefix = "Hello, ";
        Function<String, String> concatLambda = s -> prefix.concat(s);
        Function<String, String> concatMethodRef = prefix::concat;

        System.out.println("\nInstance method:");
        System.out.println(concatMethodRef.apply("Java"));

        // Constructor reference
        Supplier<ArrayList<String>> listLambda = () -> new ArrayList<>();
        Supplier<ArrayList<String>> listMethodRef = ArrayList::new;

        ArrayList<String> list = listMethodRef.get();
        list.add("Created");
        list.add("with");
        list.add("method reference");
        System.out.println("\nConstructor reference: " + list);

        // Array of method references
        System.out.println("\nUsing method references with collections:");
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }



    private static void demonstrateStreamAPI() {
        System.out.println("\n>>> Stream API with Lambdas:");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter - get even numbers
        System.out.println("\nEven numbers:");
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        // Map - square each number
        System.out.println("\nSquared numbers:");
        List<Integer> squared = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(squared);

        // Reduce - sum all numbers
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("\nSum of all numbers: " + sum);

        // Chaining operations
        System.out.println("\nChained operations (filter even, square, sum):");
        int result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Result: " + result);

        // Working with strings
        System.out.println("\nString operations:");
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");

        fruits.stream()
                .filter(fruit -> fruit.length() > 5)
                .map(String::toUpperCase)
                .sorted()
                .forEach(fruit -> System.out.println("  " + fruit));

        // Count, Min, Max
        System.out.println("\nStatistics:");
        long count = numbers.stream().filter(n -> n > 5).count();
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);

        System.out.println("Count of numbers > 5: " + count);
        System.out.println("Max: " + max.orElse(0));
        System.out.println("Min: " + min.orElse(0));

        // Collecting to different collections
        System.out.println("\nCollecting results:");
        Set<Integer> uniqueSet = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println("Even numbers as Set: " + uniqueSet);

        String joined = fruits.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Joined fruits: " + joined);
    }
}