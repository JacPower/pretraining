package org.example.testing.test;

import org.example.testing.Calculator;
import org.example.testing.MathService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathServiceTest {

    private Calculator calculator;
    private MathService mathService;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(); // Later can replace with Mockito mock
        mathService = new MathService(calculator);
    }

    @Test
    void testComputeSquareSum() {
        int result = mathService.computeSquareSum(2, 3);
        // (2 + 3)^2 = 25
        assertEquals(25, result);
    }
}
