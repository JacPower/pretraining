package org.example.testing;

public class MathService {

    private final Calculator calculator;

    public MathService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int computeSquareSum(int a, int b) {
        int sum = calculator.add(a, b);
        return calculator.multiply(sum, sum);
    }
}
