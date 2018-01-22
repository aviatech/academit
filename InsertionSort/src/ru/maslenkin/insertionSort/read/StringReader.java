package ru.maslenkin.insertionSort.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Александр on 22.01.2018.
 */
public class StringReader {
    public static ArrayList<String> readInputFile(String fileInput) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<>(100);
        try (Scanner scan = new Scanner(new FileInputStream(fileInput))) {
            while (scan.hasNextLine()) {
                lines.add(scan.nextLine());
            }
        }
        return lines;
    }
}


