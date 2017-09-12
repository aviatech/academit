package ru.academit.maslenkin.main;

import ru.academit.maslenkin.range.Range;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало диапазона");
        double from = scanner.nextDouble();

        System.out.println("Введите конец диапазона");
        double to = scanner.nextDouble();

        System.out.println("Введите число");
        double x = scanner.nextDouble();

        Range range = new Range(from, to);
        boolean result = range.isInside(x);
        System.out.println(result);
        range.print();
    }
}
