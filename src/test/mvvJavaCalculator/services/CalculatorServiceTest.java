package services;

import mvvJavaCalculator.services.CalculatorService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void testAdd() {
        BigDecimal result = calculatorService.add(new BigDecimal("5.44"), new BigDecimal("3.489"));

        assertEquals(new BigDecimal("8.929"), result, "5.44 + 3.489 should be 8.929");
    }

    @Test
    void testSubtract() {
        BigDecimal result = calculatorService.subtract(new BigDecimal("4.789523"), new BigDecimal("22.54454"));

        assertEquals(new BigDecimal("-17.755017"), result, "4.789523 - 22.54454 should be -17.755017");
    }

    @Test
    void testMultiply() {
        BigDecimal result = calculatorService.multiply(new BigDecimal("5.66"), new BigDecimal("9.88"));

        assertEquals(new BigDecimal("55.9208"), result, "5.66 * 9.88 should be 55.9208");
    }

    @Test
    void testDivide() {
        BigDecimal result = calculatorService.divide(new BigDecimal("100"), new BigDecimal("20"));
        BigDecimal expectedValue = new BigDecimal("5");

        assertEquals(0, result.compareTo(expectedValue), "100 / 20 should be 5");
    }

    @Test
    void testDivideByZero() {
        Exception exception = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(new BigDecimal("100"), BigDecimal.ZERO);
        });

        assertEquals("Cannot divide by Zero!", exception.getMessage());
    }
}
