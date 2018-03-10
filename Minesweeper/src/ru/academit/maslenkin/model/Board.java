package ru.academit.maslenkin.model;

/**
 * Created by Александр on 12.02.2018.
 */
public class Board {
    private Cell[][] cells; // массив ячееек
    private Cell[] bombs; // массив для хранения "бомб"
    private int nRow;
    private int nColumns;
    private int numUnexposedRemaining; // количество неоткрытых ячеек

    public Board(Cell[] bombs, int nRow, int nColumns) {
        this.bombs = bombs;
        this.nRow = nRow;
        this.nColumns = nColumns;
        cells = new Cell[nRow][nColumns];
        for (int i = 0; i <= nRow; ++i) {
            for (int j = 0; j <= nColumns; ++j) {
                cells[i][j] = new Cell(nRow, nColumns);
            }
        }
    }
}
