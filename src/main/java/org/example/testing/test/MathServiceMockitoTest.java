package org.example.testing.test;

import org.example.testing.Calculator;
import org.example.testing.MathService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MathServiceMockitoTest {

    @Mock
    private Calculator calculatorMock;

    private MathService mathService;



    @BeforeEach
    void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);
        // Inject mock into service
        mathService = new MathService(calculatorMock);
    }



    @Test
    void testComputeSquareSumWithMock() {
        // Arrange: stub Calculator methods
        when(calculatorMock.add(2, 3)).thenReturn(5);
        when(calculatorMock.multiply(5, 5)).thenReturn(25);

        // Act: call service method
        int result = mathService.computeSquareSum(2, 3);

        // Assert
        assertEquals(25, result);

        // Verify interactions
        verify(calculatorMock).add(2, 3);
        verify(calculatorMock).multiply(5, 5);
    }



    @Test
    void testComputeSquareSumWithDifferentValues() {
        when(calculatorMock.add(4, 6)).thenReturn(10);
        when(calculatorMock.multiply(10, 10)).thenReturn(100);

        int result = mathService.computeSquareSum(4, 6);

        assertEquals(100, result);
        verify(calculatorMock).add(4, 6);
        verify(calculatorMock).multiply(10, 10);
    }
}
