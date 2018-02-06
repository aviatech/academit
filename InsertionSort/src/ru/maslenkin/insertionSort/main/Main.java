package ru.maslenkin.insertionSort.main;

import ru.maslenkin.insertionSort.error.ArgumentErrorException;
import ru.maslenkin.insertionSort.read.IntegerNumberReader;
import ru.maslenkin.insertionSort.read.StringReader;
import ru.maslenkin.insertionSort.sort.InsertionSort;
import ru.maslenkin.insertionSort.sort.IntegerComparator;
import ru.maslenkin.insertionSort.sort.SortingMode;
import ru.maslenkin.insertionSort.sort.StringComparator;
import ru.maslenkin.insertionSort.write.WriteFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Александр on 22.01.2018.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        try {
            String nameFileInput = args[0];
            String nameFileOutput = args[1];
            String typeData = args[2];
            String sortingMode = args[3];
            if (args.length != 4) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                switch (typeData) {
                    case "-s":
                        ArrayList<String> stringArrayList = StringReader.readInputFile(nameFileInput);
                        InsertionSort.sorting(stringArrayList, SortingMode.select(sortingMode, new StringComparator()));
                        WriteFile.write(stringArrayList, nameFileOutput);
                        break;
                    case "-i":
                        ArrayList<Integer> integerArrayList = IntegerNumberReader.readInputFile(nameFileInput);
                        InsertionSort.sorting(integerArrayList, SortingMode.select(sortingMode, new IntegerComparator()));
                        WriteFile.write(integerArrayList, nameFileOutput);
                        break;
                    default:
                        throw new ArgumentErrorException();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Не найден входной файл");
        } catch (IOException e) {
            System.out.println("Ошибка записи выходного файла");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка в 4-ом аргументе, режим сортировки указан неверно: -а по возрастанию -d по убыванию");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Необходимо указать 4 аргумента" + System.lineSeparator() + "1: имя входного файла" + System.lineSeparator() + "2: имя выходного файла" +
                    System.lineSeparator() + "3: -i сортировка чисел, -s сортировка строк" + System.lineSeparator() +
                    "4:-а сортировка по возрастанию -d сортировка по убыванию");
        } catch (ArgumentErrorException e) {
            System.out.println("Ошибка в 3-ем аргументе неверно указан тип входных данных: -i целые числа -s строки");
        }
    }

}
