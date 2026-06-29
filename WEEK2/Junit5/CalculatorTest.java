package WEEK2.Junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        calculator c = new calculator();
        int result = c.add(10, 5);
        int expected = 15;

        assertEquals(result, expected);
    }

    @Test
    public void testSub() {
        calculator c2 = new calculator();

        int result = c2.substract(9, 3);
        int expected = 6;

        assertEquals(result, expected);
    }
}
