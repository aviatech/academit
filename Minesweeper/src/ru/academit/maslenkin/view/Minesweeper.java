package ru.academit.maslenkin.view;

import ru.academit.maslenkin.model.Board;

/**
 * Created by Александр on 08.03.2018.
 */
public interface Minesweeper {
    void newGame(boolean isStart);

    Board move(int x, int y, int nRows, int nColumns, int bomb, boolean isOpen, boolean isGuess, boolean isBomb);
}
