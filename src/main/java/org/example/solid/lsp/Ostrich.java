package org.example.solid.lsp;

public class Ostrich implements Bird {
    @Override
    public void eat() { System.out.println("Ostrich eating"); }

    // No fly() method → avoids breaking LSP
}
