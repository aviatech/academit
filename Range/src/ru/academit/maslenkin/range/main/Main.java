package ru.academit.maslenkin.range.main;

import ru.academit.maslenkin.range.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало и конец первого интервала");
        double from1 = scanner.nextDouble();
        double to1 = scanner.nextDouble();

        System.out.println("Введите начало и конец второго интервала");
        double from2 = scanner.nextDouble();
        double to2 = scanner.nextDouble();

        System.out.println("Введите число");
        double x = scanner.nextDouble();

        Range range1 = new Range(from1, to1);
        Range range2 = new Range(from2, to2);

        Range range3 = range1.getIntersection(range2);
        System.out.printf("%s, %s%n", range1.isInside(x), range2.isInside(x));
        if (range3 == null) {
            System.out.println("Пересечений нет");
        } else {
            System.out.printf("Результат пересечения: %.1f, %.1f%n", range3.getFrom(), range3.getTo());
        }

        Range[] arrayAssociation = range1.getAssociation(range2);
        Range.print(arrayAssociation);

        range1.print();
        range2.print();
    }
}
