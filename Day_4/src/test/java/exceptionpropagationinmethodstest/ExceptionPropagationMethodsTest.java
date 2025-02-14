package exceptionpropagationinmethodstest;

import org.junit.jupiter.api.Test;

import com.exceptionpropagationinmethods.ExceptionPropagationMethods;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionPropagationMethodsTest {
    @Test
    void ExceptionPropagationMethodsTest(){
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> ExceptionPropagationMethods.method2());
        assertEquals("/ by zero", exception.getMessage());
    }

}
