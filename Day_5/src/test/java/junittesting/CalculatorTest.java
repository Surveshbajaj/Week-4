package junittesting;


import static org.junit.jupiter.api.Assertions.*;

import com.junit.basicjunittest.Calculator;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testAddition(){
        assertEquals(20, Calculator.add(5,15));
        assertEquals(5, Calculator.add(2,3));
    }

    @Test
    void testSubtraction(){
        assertEquals(20, Calculator.subtract(50,30));
        assertEquals(1, Calculator.subtract(12,11));
    }

    @Test
    void testMultiplication(){
        assertEquals(20, Calculator.multiply(2,10));
        assertEquals(20, Calculator.multiply(5,4));
    }

    @Test
    void testDivision(){
        assertEquals(5, Calculator.divide(20,4));
        assertEquals(2, Calculator.divide(4,2));
    }


}