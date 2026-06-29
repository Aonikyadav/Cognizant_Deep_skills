package WEEK2.Junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorFixtureTest {

    private calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new calculator();
        System.out.println("Setup method called");
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown method called");
    }

    @Test
    public void testAddUsingAAA() {
        int x = 6;
        int y = 4;

        int result = calculator.add(x, y);

        assertEquals(10, result);
    }

    @Test
    public void testSubtractUsingAAA() {
        int x = 10;
        int y = 3;

        int result = calculator.substract(x, y);

        assertEquals(7, result);
    }
}
