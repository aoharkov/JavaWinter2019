package task.task4.p1;

class TemperatureConverter {
    double convertFtoC(double degreesFahrenheit) {
        return (degreesFahrenheit - 32.0) / 9.0 * 5.0;
    }

    double convertCtoF(double degreesCelsius) {
        return degreesCelsius / 5.0 * 9.0 + 32.0;
    }

    double convertCtoK(double degreesCelsius) {
        return degreesCelsius + 273.2;
    }

    double convertKtoC(double kelvin) {
        return kelvin - 273.2;
    }

    double convertFtoK(double degreesFahrenheit) {
        return (degreesFahrenheit + 459.7) / 9.0 * 5.0;
    }

    double convertKtoF(double kelvin) {
        return kelvin / 5.0 * 9.0 - 459.7;
    }
}
