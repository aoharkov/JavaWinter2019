package task4.p1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class TemperatureConverterTest {
    private TemperatureConverter converter;
    private static final double PRECISION = 0.1;
    @Parameterized.Parameter
    public double degreesCelsius;
    @Parameterized.Parameter(1)
    public double kelvin;
    @Parameterized.Parameter(2)
    public double degreesFahrenheit;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
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
    public void convertFtoC() {
        assertEquals(degreesCelsius, converter.convertFtoC(degreesFahrenheit), PRECISION);
    }

    @Test
    public void convertCtoF() {
        assertEquals(degreesFahrenheit, converter.convertCtoF(degreesCelsius), PRECISION);
    }

    @Test
    public void convertCtoK() {
        assertEquals(kelvin, converter.convertCtoK(degreesCelsius), PRECISION);
    }

    @Test
    public void convertKtoC() {
        assertEquals(degreesCelsius, converter.convertKtoC(kelvin), PRECISION);
    }

    @Test
    public void convertFtoK() {
        assertEquals(kelvin, converter.convertFtoK(degreesFahrenheit), PRECISION);
    }

    @Test
    public void convertKtoF() {
        assertEquals(degreesFahrenheit, converter.convertKtoF(kelvin), PRECISION);
    }
}