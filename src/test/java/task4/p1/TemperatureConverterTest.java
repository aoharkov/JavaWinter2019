package task4.p1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TemperatureConverterTest {
    private TemperatureConverter converter;
    @Parameterized.Parameter
    public double parameter;
    @Parameterized.Parameter(1)
    public double expected;
    @Parameterized.Parameter(2)
    public double expected2;
    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][] {
            {0.0, 273.2, 32},
            {-273.2, 0.0, -459.76},
            {3.0, 276.2, 37.4}
            });
    }

    @Before
    public void setup() {
        converter = new TemperatureConverter();
    }

    @Test
    public void convertCtoK() {
        double temperature = converter.convertCtoK(parameter);
        assertEquals(expected, temperature, 0.05);
    }

    @Test
    public void convertCtoF() {
        assertEquals(expected2, converter.convertCtoF(parameter), 0.05);
    }

    @Test
    public void convertKtoC() {
        assertEquals(parameter, converter.convertCtoK(parameter), 0.05);
    }
}