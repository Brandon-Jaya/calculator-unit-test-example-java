package ec.edu.epn.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Prueba unitaria que realiza la verificacion del metodo sum")
    public void testSum() {
        /*
         * //Arrange + Act
         * int result = calculator.sum(2, 2);
         * //Assert
         * assertEquals(4, result);
         */
        assertAll("Suma valores en varios casos",
                () -> {
                    int resultado = calculator.sum(2, 2);
                    assertEquals(4, resultado);
                },
                () -> assertEquals(0, calculator.sum(-1, 1)));
    }

    @Test
    public void testSum2() {
        // Arrange + Act
        int result = calculator.sum(4, 6);
        // Assert
        assertEquals(10, result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "10, 5, 15"
    })

    public void testSumMultipleData(int a, int b, int expected) {
        int result = calculator.sum(a, b);
        assertEquals(expected, result);

    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    public void testSumWithFixedValues(int value) {
        // Arrange + Act
        int result = calculator.sum(value, 0);
        // Assert
        assertEquals(value, result);
    }

    @Test
    public void testMinus() {
        int result = calculator.minus(2, 1);
        assertEquals(1, result);
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(2, 2);
        assertEquals(4, result);
    }

    @Test
    public void testDivide() {
        int result = calculator.divide(4, 2);
        assertEquals(2, result);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }
}
