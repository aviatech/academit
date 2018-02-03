package ru.academit.maslenkin.model;

import ru.academit.maslenkin.common.TemperatureConverter;

/**
 * Created by Александр on 01.02.2018.
 */
public class Converter implements TemperatureConverter {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double convertToCelsius(double inputTemperature) {
        return 0;
    }

    @Override
    public double convertFromCelsius(double inputTemperature) {
        return 0;
    }

    @Override
    public double convert(double temperature, TemperatureConverter from, TemperatureConverter to) {
        return to.convertFromCelsius(from.convertToCelsius(temperature));
    }
}
