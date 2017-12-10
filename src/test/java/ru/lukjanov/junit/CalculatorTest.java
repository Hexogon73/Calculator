package ru.lukjanov.junit;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Start CalculatorTest");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Finish CalculatorTest");
    }

    @Before
    public void initTest() {
        calculator = new Calculator();
    }

    @After
    public void afterTest() {
        calculator = null;
    }


    @Test
    public void testGetSum() {
        assertEquals(10, calculator.getSum(8, 2), 0.0);
    }

    @Test
    public void testGetSubtract() {
        assertEquals(6, calculator.getSubtract(8, 2), 0.0);
    }

    @Test
    public void testGetMultiple() {
        assertEquals(50, calculator.getMultiple(10, 5), 0.0);
    }

    @Test
    public void testGetDivide() {
        assertEquals(20, calculator.getDivide(100, 5), 0.0);
    }

//    @Test(expected = ArithmeticException.class)
//    public void divisionWithException() {
//        calculator.getDivide(15,0);
//    }

//    @Test
//    public void testGetDivide() throws Exception {
//        assertEquals(20, calculator.getDivide(100, 5), 0.0);
//    }

    @Test
    public void testGetSQRT() {
        assertEquals(8, calculator.getSQRT(64), 0.0);
    }
}