package ru.academit.maslenkin.model;

/**
 * Created by Александр on 12.02.2018.
 */
public class Cell {
    private int row;
    private int column;
    private boolean isBomb;
    private boolean isOpen = false;
    private boolean isGuess = false;
    private int bombCounter;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isGuess() {
        return isGuess;
    }

    public void setGuess(boolean guess) {
        isGuess = guess;
    }

    public int getBombCounter() {
        return bombCounter;
    }

    public void setBombCounter(int bombCounter) {
        this.bombCounter = bombCounter;
    }

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
