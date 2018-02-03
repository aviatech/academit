package ru.academit.maslenkin.controller;

/**
 * Created by Александр on 01.02.2018.
 */

import ru.academit.maslenkin.common.DeterminantConverter;
import ru.academit.maslenkin.common.TemperatureConverter;
import ru.academit.maslenkin.common.View;
import ru.academit.maslenkin.common.ViewListener;

/**
 * Контроллер
 */
public class Controller implements ViewListener {
    private final DeterminantConverter temperatureConverter;
    private final View view;

    public Controller(DeterminantConverter temperatureConverter, View view) {
        this.temperatureConverter = temperatureConverter;
        this.view = view;
    }

    @Override
    public void needConvertTemperature(double inputTemperature, TemperatureConverter itemFrom, TemperatureConverter itemTo) {
        // Переводит температуру при помощи модели, оповещает View об изменении данных
        // В данном случае, данные передаются в метод
        view.onTemperatureConverted(temperatureConverter.convert(inputTemperature, itemFrom, itemTo));
    }
}