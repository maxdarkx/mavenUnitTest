package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testint sum (1 + 1)= 2")
    public void sum()
    {
        Long number1 = 1L;
        Long number2 = 1L;
        Long result;
        Long expectedValue = 2L;

        //act
        result = basicCalculator.sum(number1, number2);

        //assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }


    @DisplayName("Testing several subtractions")
    @ParameterizedTest(name = "{1} - {2} = {1}")
    @CsvSource({
            "1,    1,   0",
            "3,    1,   2",
            "100,  48, 52",
            "1000,  80, 920"
    })
    public void severalSubtractions(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.subtract(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several mults")
    @ParameterizedTest(name = "{2} x {1} = {2}")
    @CsvSource({
            "2,    1,   2",
            "3,    2,   6",
            "100,  3, 300",
            "1000,  1000, 1000000"
    })
    public void severalMults(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiply(first, second),
                () -> first + " x " + second + " should equal " + expectedResult);
    }
    @DisplayName("Testing several divisions")
    @ParameterizedTest(name = "{4} / {2} = {2}")
    @CsvSource({
            "4,    2,   2",
            "10,    5,   2",
            "72,  8, 9",
            "100,  10, 10"
    })
    public void severalDivisions(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.divide(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }

}
