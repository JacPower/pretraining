package org.example.abstraction;

public abstract class Vehicle {
    // Fields
    protected String brand;
    protected String model;
    protected int year;
    protected boolean isRunning;



    // Constructor
    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.isRunning = false;
    }



    // Abstract methods - must be implemented by subclasses
    public abstract void start();

    public abstract void stop();

    public abstract void accelerate(int speed);



    // Concrete method - can be inherited as-is
    public void displayInfo() {
        System.out.println("\n--- Vehicle Information ---");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Status: " + (isRunning ? "Running" : "Stopped"));
    }



    public void honk() {
        System.out.println("Beep! Beep!");
    }



    // Getters
    public String getBrand() {
        return brand;
    }



    public String getModel() {
        return model;
    }



    public int getYear() {
        return year;
    }



    public boolean isRunning() {
        return isRunning;
    }



    // Protected method accessible to subclasses
    protected void setRunning(boolean running) {
        this.isRunning = running;
    }
}
