package test;

import static org.junit.jupiter.api.Assertions.*;

import main.JUnitDemo;
import org.junit.jupiter.api.Test;

class JUnitTestCase {

//    @Test
//    void test() {
//        fail("Not yet implemented");
//    }
//    //remove this default test method and include the one below
//    //the above is how to fail a test. remove the code to have your tests passing

    //include this below test case
    @Test
    void testAdd() {
        JUnitDemo test = new JUnitDemo();
        int output = test.add(1, 2);
        //test.add where add is the method created in the JUnitDemo class
        assertEquals(3, output);
    }

    @Test
    void testSubtract() {
        JUnitDemo test = new JUnitDemo();
        int output = test.subtract(5, 3);
        //test.add where add is the method created in the JUnitDemo class
        assertSame(2, output);
    }

    @Test
    void testMultiply() {
        JUnitDemo test = new JUnitDemo();
        int output = test.multiply(5, 3);
        //test.add where add is the method created in the JUnitDemo class
        assertEquals(15, output);
    }

    @Test
    void testDivision() {
        JUnitDemo test = new JUnitDemo();
        int output = test.division(15, 3);
        //test.add where add is the method created in the JUnitDemo class
        assertEquals(5, output);
    }

    @Test
    void testSquare() {
        JUnitDemo test = new JUnitDemo();
        int output = test.square(2);
        //test.add where add is the method created in the JUnitDemo class
        assertEquals(4, output);
    }

    @Test
    void isOddNumberFalse() {
        JUnitDemo test = new JUnitDemo();
        boolean output = test.isOddNumber(2);
        //test.add where add is the method created in the JUnitDemo class
        assertFalse(output);
    }

    @Test
    void isOddNumberTrue() {
        JUnitDemo test = new JUnitDemo();
        boolean output = test.isOddNumber(5);
        //test.add where add is the method created in the JUnitDemo class
        assertTrue(output);
    }

    @Test
    void testDivideWithZero() {
        JUnitDemo test = new JUnitDemo();
        //int output = test.division(10, 0);
        assertThrows(ArithmeticException.class, () -> {
            test.division(10, 0);
        });
    }

//    @Test
//    void isSetListNull() {
//        JUnitDemo test = new JUnitDemo();
//        boolean output = test.isOddNumber(5);
//        //test.add where add is the method created in the JUnitDemo class
//        assertTrue(output);
//    }


}