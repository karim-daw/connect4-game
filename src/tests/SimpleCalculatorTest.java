package src.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.SimpleCalculator;

public class SimpleCalculatorTest {
    @Test
    public void testAddTwoNumbers() {
        var calculator = new SimpleCalculator();
        assertEquals(4, calculator.addTwoNumbers(2, 2));

    }
}
