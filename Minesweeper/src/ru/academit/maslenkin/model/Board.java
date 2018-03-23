package ru.academit.maslenkin.model;

import java.util.Random;

/**
 * Created by Александр on 12.02.2018.
 */
public class Board {
    private Cell[][] cells; // массив ячееек
    private Cell[] bombs; // массив для хранения "бомб"
    private int nRow;
    private int nColumns;
    private int numUnexposedRemaining; // количество неоткрытых ячеек

    public void Board(Cell[] bombs, int nRow, int nColumns) {
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

    public  Cell[] shuffleBomb() {
        int quantityCells = nRow * nColumns;
        Random random = new Random();
        for (int i = 0; i < quantityCells; ++i) {
            int index1 = i;
            int index2 = index1 + random.nextInt(quantityCells - index1);
            if (index1 != index2) {
                int row1 = index1 / nColumns;
                int column1 = (index1 - row1 * nColumns) % nColumns;
                Cell cell1 = cells[row1][column1];

                int row2 = index2 / nColumns;
                int column2 = (index2 - row2 * nColumns) % nColumns;
                Cell cell2 = cells[row2][column2];
            }

        }

        return new Cell[quantityCells];
    }
}
