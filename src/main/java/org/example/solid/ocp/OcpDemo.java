package org.example.solid.ocp;

import java.util.List;

public class OcpDemo {
    public static void show() {
        List<Shape> shapes = List.of(
                new Circle(5),
                new Rectangle(4, 6)
        );

        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Total area = " + calculator.calculateTotalArea(shapes));
    }
}
