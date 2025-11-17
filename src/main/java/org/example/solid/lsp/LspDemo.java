package org.example.solid.lsp;

public class LspDemo {
    public static void show() {
        Bird parrot = new Parrot();
        Bird ostrich = new Ostrich();

        parrot.eat();
        ostrich.eat();
    }
}
