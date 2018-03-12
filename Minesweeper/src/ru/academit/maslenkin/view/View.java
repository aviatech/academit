package ru.academit.maslenkin.view;

/**
 * Created by Александр on 12.03.2018.
 */
public interface View {
    void startApplication();
    void addViewListener(ViewListener listener);
}
