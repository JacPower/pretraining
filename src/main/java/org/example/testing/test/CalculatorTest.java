package org.example.testing.test;

import org.example.testing.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAddition() {
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    void testSubtraction() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    void testMultiplication() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(8, 4));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(5, 0));
    }
}
