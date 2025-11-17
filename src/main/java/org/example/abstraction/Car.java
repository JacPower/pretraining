package org.example.abstraction;

public class Car extends Vehicle {
    // Additional field specific to Car
    private int numberOfDoors;
    private String transmissionType;



    // Constructor
    public Car(String brand, String model, int year) {
        super(brand, model, year);
        this.numberOfDoors = 4; // Default
        this.transmissionType = "Automatic"; // Default
    }



    // Constructor with additional parameters
    public Car(String brand, String model, int year, int numberOfDoors, String transmissionType) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
    }



    // Implementation of abstract method
    @Override
    public void start() {
        if (!isRunning) {
            setRunning(true);
            System.out.println("🚗 " + brand + " " + model + " engine started!");
            System.out.println("Vroom! Vroom!");
        } else {
            System.out.println("Car is already running!");
        }
    }



    // Implementation of abstract method
    @Override
    public void stop() {
        if (isRunning) {
            setRunning(false);
            System.out.println("🛑 " + brand + " " + model + " engine stopped!");
        } else {
            System.out.println("Car is already stopped!");
        }
    }



    // Implementation of abstract method
    @Override
    public void accelerate(int speed) {
        if (isRunning) {
            System.out.println("🏎️  Accelerating to " + speed + " km/h");
            if (speed > 100) {
                System.out.println("⚠️  High speed! Drive safely!");
            }
        } else {
            System.out.println("⚠️  Cannot accelerate. Please start the engine first!");
        }
    }



    // Car-specific methods
    public void openTrunk() {
        System.out.println("Trunk opened");
    }



    public void closeTrunk() {
        System.out.println("Trunk closed");
    }



    // Override displayInfo to add car-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Transmission: " + transmissionType);
        System.out.println("Type: Car");
    }



    // Getters and Setters
    public int getNumberOfDoors() {
        return numberOfDoors;
    }



    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }



    public String getTransmissionType() {
        return transmissionType;
    }



    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
}
