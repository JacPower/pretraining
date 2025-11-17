---

# Java Design Patterns & OOP Notes

## 1. Introduction

* Design Patterns are **reusable solutions** to common software design problems.
* Help achieve **maintainability, scalability, and flexibility** in code.
* Categories:

  1. **Creational Patterns** – Object creation mechanisms.
  2. **Structural Patterns** – Object composition and structure.
  3. **Behavioral Patterns** – Object interaction and responsibility.

---

## 2. Creational Patterns (Summary & Examples)

* Focus on **how objects are created**.
* Common types:

### Singleton

Ensures a class has only one instance.

```java
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if(instance == null) instance = new Singleton();
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

Step-by-step object construction.

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
    private User(Builder builder) { this.name = builder.name; this.age = builder.age; }
}
```

---

## 3. Behavioural Patterns

### 3.1 Strategy Pattern

* Defines a family of algorithms and **makes them interchangeable**.
* **Use Case:** When multiple behaviors can be selected at runtime.

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

### 3.2 Template Method Pattern

* Defines the **skeleton of an algorithm**, deferring some steps to subclasses.
* Promotes **code reuse** and **inversion of control**.

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

## 4. SOLID Principles

1. **S – Single Responsibility Principle (SRP)**: A class should have **only one reason to change**.
2. **O – Open/Closed Principle (OCP)**: Open for extension, closed for modification.
3. **L – Liskov Substitution Principle (LSP)**: Subtypes must be **replaceable** by their base types without breaking functionality.
4. **I – Interface Segregation Principle (ISP)**: Many **specific interfaces** are better than a single general-purpose interface.
5. **D – Dependency Inversion Principle (DIP)**: Depend on **abstractions**, not concrete implementations.

**Example (SRP):**

```java
class Invoice { void calculateTotal() {} }
class InvoicePrinter { void print(Invoice invoice) {} } // Separate responsibility
```

---

## Summary

* Creational patterns: Focus on object creation (Singleton, Factory, Builder).
* Behavioural patterns: Focus on **how objects interact** (Strategy, Template Method).
* SOLID: Guides writing **clean, maintainable, and flexible OOP code**.

---
