package task1.main.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Александр on 21.11.2017.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> stringArrayList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"))) {
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                stringArrayList.add(string);
            }
        }

        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(3, 3, 3, 1, 5, 2, 1, 3, 5));
        int i = 0;
        while (i < integerArrayList.size()) {
            if (integerArrayList.get(i) % 2 == 0) {
                integerArrayList.remove(i);
            } else {
                i++;
            }
        }
        System.out.println(integerArrayList);

        ArrayList<Integer> arrayList = new ArrayList<>(integerArrayList);
        ArrayList<Integer> newArrayList = new ArrayList<>();
        for (Integer e : arrayList) {
            if (!newArrayList.contains(e)) {
                newArrayList.add(e);
            }
        }
        System.out.println(newArrayList);
    }
}
