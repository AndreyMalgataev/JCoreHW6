import classes.Calculator;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calc;

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("Start test");
        calc = new Calculator();
    }

    @Test
    public void testPlus() {
        //arrange
        int a = 2, b = 1, expected = 3;

        //act
        int result = calc.plus.apply(a, b);

        //assert
        assertEquals(expected, result);
    }

    @Test
    public void testIsPositive() {
        //arrange
        int a = 2;

        //act
        boolean result = calc.isPositive.test(a);

        //assert
        assertTrue(result);
    }

    @Test
    public void testDivide() {
        //arrange
        int a = 2, b = 2, expected = 1;
        Class<ArithmeticException> expectedError = ArithmeticException.class;

        //act
        Integer result = calc.divide.apply(a, b);

        //assert
        assertEquals(expected, result);
        assertDoesNotThrow(() -> calc.divide.apply(a, b), String.valueOf(expectedError));
    }

    @Test
    public void testHashMap() {
        //arrange
        int a = 4, b = 2;

        //act
        List<Integer> result = calc.multipleCalculations(a, b);

        //assert
        assertThat(result, hasItems(6,2,8,2));
    }
}
