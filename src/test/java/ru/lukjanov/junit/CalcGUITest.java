package ru.lukjanov.junit;

import org.junit.*;

import static org.junit.Assert.*;

public class CalcGUITest {

    private CalcGUI calculator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Start CalcGUITest");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Finish CalcGUITest");
    }

    @Before
    public void setUp() throws Exception {
        calculator = new CalcGUI();
    }

    @After
    public void tearDown() throws Exception {
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