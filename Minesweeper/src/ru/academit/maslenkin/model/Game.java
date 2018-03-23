package ru.academit.maslenkin.model;

/**
 * Created by Александр on 10.03.2018.
 */
public class Game {
    private Board board;
    private int rows;
    private int columns;
    private int bombs;
    private GameState state;

    public Game(int rows, int columns, int bombs) {
        this.rows = rows;
        this.columns = columns;
        this.bombs = bombs;
    }


}
