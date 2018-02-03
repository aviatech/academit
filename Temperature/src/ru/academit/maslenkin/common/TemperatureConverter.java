package ru.academit.maslenkin.common;

/**
 * Created by Александр on 01.02.2018.
 */

/**
 * Интерфейс модели преобразования температуры между шкалами
 */
public interface TemperatureConverter {
    /* Преобразует температуру в градусах чего-то в некоторую другую шкалу*/
    String getName();

    double convertToCelsius(double inputTemperature);

    double convertFromCelsius(double inputTemperature);


}
