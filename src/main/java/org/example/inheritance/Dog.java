package org.example.inheritance;

public class Dog extends Animal {
    // Additional field specific to Dog
    private String breed;

    // Constructor
    public Dog(String name, int age, String breed) {
        super(name, age); // Call parent constructor
        this.breed = breed;
    }

    // Override parent method
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }

    // Override displayInfo to add breed information
    @Override
    public void displayInfo() {
        System.out.println("\n--- Dog Information ---");
        super.displayInfo(); // Call parent method
        System.out.println("Breed: " + breed);
        System.out.println("Type: Dog");
    }

    // Dog-specific method
    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }

    public void wagTail() {
        System.out.println(name + " is wagging tail happily!");
    }

    // Getter and Setter for breed
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}

