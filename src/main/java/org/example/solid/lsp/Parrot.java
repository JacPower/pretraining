package org.example.solid.lsp;

public class Parrot implements FlyingBird {
    @Override
    public void eat() {
        System.out.println("Parrot eating");
    }



    @Override
    public void fly() {
        System.out.println("Parrot flying");
    }
}
