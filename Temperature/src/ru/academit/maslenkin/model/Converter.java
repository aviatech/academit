package ru.academit.maslenkin.model;

import ru.academit.maslenkin.common.DeterminantConverter;
import ru.academit.maslenkin.common.TemperatureConverter;

/**
 * Created by Александр on 01.02.2018.
 */
public class Converter implements DeterminantConverter {
    @Override
    public double convert(double temperature, TemperatureConverter from, TemperatureConverter to) {
        return to.convertFromCelsius(from.convertToCelsius(temperature));
    }
}
