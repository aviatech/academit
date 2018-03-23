package ru.academit.maslenkin.model;

/**
 * Created by Александр on 12.02.2018.
 */
public class Cell {
    private int row;
    private int column;
    private boolean isBomb; // в ячейке бомба
    private boolean isOpen = false; // открытая ячейка
    private boolean isGuess = false; // предполагаем что в ячейке бомба
    private int bombCounter;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

   /* public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Cell cell = (Cell) object;
        return this.row == cell.row && this.column == cell.column;
    }*/

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


    public boolean flip() {   // клик по ячейке
        isOpen = true;        // признак открытой ячейки меняем на true
        return !isBomb;       //  возвращаем признак наличия бомбы с значением false
    }
}
