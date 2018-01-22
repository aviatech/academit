package ru.maslenkin.insertionSort.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Александр on 22.01.2018.
 */
public class IntegerNumberReader {
    public static ArrayList<Integer> readInputFile(String fileInput) throws FileNotFoundException {

        ArrayList<Integer> numberArray = new ArrayList<>(100);
        try (Scanner scan = new Scanner(new FileInputStream(fileInput))) {
            while (scan.hasNextInt()) {
                numberArray.add(scan.nextInt());
            }
        }
        return numberArray;
    }
}
