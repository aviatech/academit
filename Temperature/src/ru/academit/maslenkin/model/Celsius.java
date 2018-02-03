package ru.academit.maslenkin.model;

import ru.academit.maslenkin.common.TemperatureConverter;

/**
 * Created by Александр on 01.02.2018.
 */
public class Celsius implements TemperatureConverter {

    @Override
    public String getName() {
        return "Celsius";
    }

    @Override
    public double convertToCelsius(double inputTemperature) {
        return inputTemperature;
    }

    @Override
    public double convertFromCelsius(double inputTemperature) {
        return inputTemperature;
    }



}