package ec.edu.epn.calculator;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSum(){
        int result = calculator.sum(2, 2);
        if (result!=4) {
            Assert.fail();
        }
    }

    @Test
    public void testMinus(){
        int result = calculator.minus(2, 1);
        if (result!=1) {
            Assert.fail();
        }
    }

    @Test
    public void testMultiply(){
        int result = calculator.multiply(2, 2);
        if (result!=4) {
            Assert.fail();
        }
    }
    
    @Test
    public void testDivide(){
        int result = calculator.divide(4, 2);
        if (result!=2) {
            Assert.fail();
        }
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(1, 0);
    }
}
