package junittesting;



import com.junit.advancedjunitpracticeproblems.TemperatureConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    @Test
    void celciusToFahrenheit(){
        assertEquals(212, TemperatureConverter.celciusToFahrenheit(100));
    }

    @Test
    void fahrenheitToCelcius(){
        assertEquals(37.77777777777778, TemperatureConverter.fahrenheitToCelcius(100));
    }




}