package ru.academit.maslenkin.common;

/**
 * Created by Александр on 01.02.2018.
 */
/**
 * Интерфейс подписчика на события View
 * Этот интерфейс реализует контроллер, чтобы View могла оповещать controller о возникновении событий
 */
public interface ViewListener {
    // событие, которое означает, что view хочет преобразовать температуру
    void needConvertTemperature(double temperature, TemperatureConverter from, TemperatureConverter to);
}