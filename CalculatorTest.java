package calculatordemo2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator classUnderTest;

    @BeforeAll
    public static void setUp() {
        classUnderTest = new Calculator();
    }

    @DisplayName("Tests subtraction function")
    @Test
    void test_sub() {
        Calculator calculator = new Calculator();
        calculator.setNum1(5.0);
        calculator.setNum2(3.0);
        calculator.setMode(Calculator.twoOperator.subtract);
        double result = calculator.twoOpOperations();
        assertEquals(2.0, result);
    }

    @DisplayName("Tests addition function")
    @Test
    void test_add() {
        Calculator calculator = new Calculator();
        calculator.setNum1(2.0);
        calculator.setNum2(3.0);
        calculator.setMode(Calculator.twoOperator.add);
        double result = calculator.twoOpOperations();
        assertEquals(5.0, result);
    }

    @DisplayName("Tests 10.0 * 9.0 / 2.0 = 45.0")
    @Test
    void two_op_test1() {
        Calculator calculator = new Calculator();
        calculator.setNum1(10.0);
        calculator.setNum2(9.0);
        calculator.setMode(Calculator.twoOperator.multiply); // set the first mode
        double result = calculator.twoOpOperations(); // first operation (10.0 * 9.0)

        calculator.setNum1(result); // set the result as the new num1 for the next operation
        calculator.setNum2(2.0);
        calculator.setMode(Calculator.twoOperator.divide);
        result = calculator.twoOpOperations(); // second operation (result / 2.0)

        assertEquals(45.0, result);
    }

    @DisplayName("Tests 10.0 / 10.0 / 2.0 = 0.5")
    @Test
    void two_op_test2() {
        Calculator calculator = new Calculator();
        calculator.setNum1(10.0);
        calculator.setNum2(10.0);
        calculator.setMode(Calculator.twoOperator.divide); // set the first mode
        double result = calculator.twoOpOperations(); // first operation (10.0 / 10.0)

        calculator.setNum1(result); // set the result as the new num1 for the next operation
        calculator.setNum2(2.0);
        calculator.setMode(Calculator.twoOperator.divide);
        result = calculator.twoOpOperations(); // second operation (result / 2.0)

        assertEquals(0.5, result);
    }

    @DisplayName("Tests 5 + 3 = 8")
    @Test
    void two_op_test4() {
        Calculator calculator = new Calculator();
        calculator.setNum1(5.0);
        calculator.setNum2(3.0);
        calculator.setMode(Calculator.twoOperator.add);
        double result = calculator.twoOpOperations();
        assertEquals(8.0, result);
    }

    @DisplayName("Tests 12 / 4 = 3")
    @Test
    void two_op_test5() {
        Calculator calculator = new Calculator();
        calculator.setNum1(12.0);
        calculator.setNum2(4.0);
        calculator.setMode(Calculator.twoOperator.divide);
        double result = calculator.twoOpOperations();
        assertEquals(3.0, result);
    }

    @DisplayName("Tests 0 - 6 * 3 = -18")
    @Test
    void two_op_test3() {
        Calculator calculator = new Calculator();
        calculator.setNum1(0.0);
        calculator.setNum2(6.0);
        calculator.setMode(Calculator.twoOperator.subtract); // set the first mode
        double result = calculator.twoOpOperations(); // first operation (0-6)

        calculator.setNum1(result); // set the result as the new num1 for the next operation
        calculator.setNum2(3.0);
        calculator.setMode(Calculator.twoOperator.multiply);
        result = calculator.twoOpOperations(); // second operation (result * 3.0)

        assertEquals(-18.0, result);
    }

    @Test
    void two_op_caller_test_normalMode() {
        Calculator calculator = new Calculator();

        // test when the calculator is in normal mode
        Double result = calculator.twoOpCaller(Calculator.twoOperator.normal, 8.0);

        // in norm the result should be the same as the input number
        assertEquals(8.0, result, 0.0001);
    }

    @DisplayName("Tests the twoOpCaller method in normal mode")
    @Test
    void testTwoOpCallerNormalMode() {
        Calculator calculator = new Calculator();
        calculator.setMode(Calculator.twoOperator.normal);
        Double result = calculator.twoOpCaller(Calculator.twoOperator.add, 5.0);
        assertEquals(5.0, result, 0.0001);
    }

    @DisplayName("Tests the square function")
    @Test
    void testSquare() {
        double num = 5.0;
        assertEquals(num * num, classUnderTest.calcScience(Calculator.singleOperator.square, num));
    }

    @DisplayName("Tests the square root function")
    @Test
    void testSquareRoot() {
        double num = 9.0;
        assertEquals(Math.sqrt(num), classUnderTest.calcScience(Calculator.singleOperator.squareRoot, num));
    }

    @DisplayName("Tests the 1/x function")
    @Test
    void testOneDividedBy() {
        double num = 2.0;
        assertEquals(1 / num, classUnderTest.calcScience(Calculator.singleOperator.oneDevidedBy, num));
    }

    @DisplayName("Tests the cosine function in degrees")
    @Test
    void testCos() {
        double num = 45.0;
        assertEquals(Math.cos(num), classUnderTest.calcScience(Calculator.singleOperator.cos, num));
    }

    @DisplayName("Tests the sine function in degrees")
    @Test
    void testSin() {
        double num = 30.0;
        assertEquals(Math.sin(num), classUnderTest.calcScience(Calculator.singleOperator.sin, num));
    }

    @DisplayName("Tests the tangent function in degrees")
    @Test
    void testTan() {
        double num = 60.0;
        assertEquals(Math.tan(num), classUnderTest.calcScience(Calculator.singleOperator.tan, num));
    }

    @DisplayName("Tests the arcsine function in degrees")
    @Test
    void testAsin() {
        double num = 0.5;
        assertEquals(Math.asin(num), classUnderTest.calcScience(Calculator.singleOperator.asin, num));
    }

    @DisplayName("Tests the arctangent function in degrees")
    @Test
    void testAtan() {
        double num = 1.0;
        assertEquals(Math.atan(num), classUnderTest.calcScience(Calculator.singleOperator.atan, num));
    }

    @DisplayName("Tests the arccosine function in degrees")
    @Test
    void testAcos() {
        double num = 0.707;
        assertEquals(Math.acos(num), classUnderTest.calcScience(Calculator.singleOperator.acos, num));
    }

    @DisplayName("Tests whether an error is thrown if a null mode is passed")
    @Test
    void testThrowError() {
        assertThrows(Error.class, () -> classUnderTest.calcScience(null, 10.0));
    }
}
