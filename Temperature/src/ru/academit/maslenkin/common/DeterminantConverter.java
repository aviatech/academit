package ru.academit.maslenkin.common;

/**
 * Created by Александр on 03.02.2018.
 */
public interface DeterminantConverter {
    double convert(double temperature, TemperatureConverter from, TemperatureConverter to);
}
