package org.example.inheritance;

public class Animal {
    // Protected fields - accessible by subclasses
    protected String name;
    protected int age;



    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }



    // Method to be inherited
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
    }



    // Method to be overridden by subclasses
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }



    // Method to demonstrate behavior
    public void eat() {
        System.out.println(name + " is eating");
    }



    public void sleep() {
        System.out.println(name + " is sleeping");
    }



    // Getters and Setters
    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public int getAge() {
        return age;
    }



    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
