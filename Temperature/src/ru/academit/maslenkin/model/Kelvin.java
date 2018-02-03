package ru.academit.maslenkin.model;

import ru.academit.maslenkin.common.TemperatureConverter;

/**
 * Created by Александр on 01.02.2018.
 */
public class Kelvin implements TemperatureConverter {
    @Override
    public double convertToCelsius(double inputTemperature) {
        return inputTemperature - 273.15;
    }

    @Override
    public double convertFromCelsius(double inputTemperature) {
        return inputTemperature + 273.15;
    }

    @Override
    public String getName() {
        return "Kelvin";
    }
}