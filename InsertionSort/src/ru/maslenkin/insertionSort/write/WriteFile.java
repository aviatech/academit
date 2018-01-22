package ru.maslenkin.insertionSort.write;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * Created by Александр on 22.01.2018.
 */
public class WriteFile {
    public static void write(ArrayList<?> array, String fileOutput) throws IOException {
        try (PrintWriter writer = new PrintWriter(fileOutput)) {
            for (Object e : array) {
                writer.println(e);
            }
        }
    }
}
