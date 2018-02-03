package ru.academit.maslenkin.model;

import ru.academit.maslenkin.common.TemperatureConverter;

/**
 * Created by Александр on 01.02.2018.
 */
public class Fahrenheit implements TemperatureConverter {

    @Override
    public double convertToCelsius(double inputTemperature) {
        return 5 * (inputTemperature - 32) / 9;
    }

    @Override
    public double convertFromCelsius(double inputTemperature) {
        return inputTemperature * 9.0 / 5.0 + 32.0;
    }

    @Override
    public String getName() {
        return "Fahrenheit";
    }
}