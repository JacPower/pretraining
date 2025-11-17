# Java Design Patterns & OOP Notes

## Introduction

Design Patterns provide **reusable solutions** to common software design problems. They help improve **code maintainability, scalability, and flexibility**. Patterns are categorized as:

1. **Creational Patterns** – Handle object creation mechanisms.
2. **Structural Patterns** – Deal with object composition and structure.
3. **Behavioral Patterns** – Define object interaction and responsibilities.

---

## Creational Patterns

Focus on **object creation** and decoupling the client from implementation.

### Singleton

Ensures a class has **only one instance**.

```java
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }
}
```

### Factory Method

Creates objects without exposing instantiation logic.

```java
interface Shape { void draw(); }
class Circle implements Shape { public void draw() { System.out.println("Circle"); } }
class Square implements Shape { public void draw() { System.out.println("Square"); } }

class ShapeFactory {
    public Shape getShape(String type) {
        return switch(type.toLowerCase()) {
            case "circle" -> new Circle();
            case "square" -> new Square();
            default -> null;
        };
    }
}
```

### Builder

Constructs complex objects **step by step**.

```java
class User {
    private String name;
    private int age;

    public static class Builder {
        private String name;
        private int age;
        public Builder setName(String name) { this.name = name; return this; }
        public Builder setAge(int age) { this.age = age; return this; }
        public User build() { return new User(this); }
    }

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }
}
```

---

## Behavioural Patterns

Focus on **how objects interact** and delegate responsibilities.

### Strategy Pattern

Defines a family of algorithms and allows **dynamic selection** at runtime.

```java
interface PaymentStrategy { void pay(int amount); }

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid " + amount + " with Credit Card."); }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid " + amount + " with PayPal."); }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    public ShoppingCart(PaymentStrategy paymentStrategy) { this.paymentStrategy = paymentStrategy; }
    public void checkout(int amount) { paymentStrategy.pay(amount); }
}

// Usage
ShoppingCart cart = new ShoppingCart(new PayPalPayment());
cart.checkout(100);
```

### Template Method Pattern

Defines the **skeleton of an algorithm**, with some steps **implemented by subclasses**.

```java
abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Football extends Game {
    void initialize() { System.out.println("Football Game Initialized!"); }
    void startPlay() { System.out.println("Football Game Started!"); }
    void endPlay() { System.out.println("Football Game Ended!"); }
}

// Usage
Game game = new Football();
game.play();
```

---

## SOLID Principles

Guidelines for writing **clean, maintainable, and flexible code**.

1. **S – Single Responsibility Principle (SRP)**: A class should have only **one reason to change**.
2. **O – Open/Closed Principle (OCP)**: Open for **extension**, closed for **modification**.
3. **L – Liskov Substitution Principle (LSP)**: Subtypes must be **replaceable** by their base types.
4. **I – Interface Segregation Principle (ISP)**: Prefer **multiple small interfaces** over a large general-purpose interface.
5. **D – Dependency Inversion Principle (DIP)**: Depend on **abstractions** rather than concrete implementations.

**Example (SRP):**

```java
class Invoice { void calculateTotal() {} }
class InvoicePrinter { void print(Invoice invoice) {} } // Separate responsibility
```

---

## Summary

* Creational Patterns: Handle object creation (Singleton, Factory, Builder).
* Behavioural Patterns: Manage object interaction (Strategy, Template Method).
* SOLID Principles: Ensure **clean, maintainable, and flexible OOP code**.
