package junittesting;

import static org.junit.jupiter.api.Assertions.*;
import com.junit.basicjunittest.ExceptionHandling;
import org.junit.jupiter.api.Test;

public class ExceptionHandlingTest {

    @Test
    void testDivision(){
        assertEquals(2, ExceptionHandling.divide(6,3));
        assertEquals(9, ExceptionHandling.divide(81,9));
    }

    @Test
    void testDivideByZeroException() { //generate exception
        Exception exception = assertThrows(ArithmeticException.class , () -> ExceptionHandling.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

}
