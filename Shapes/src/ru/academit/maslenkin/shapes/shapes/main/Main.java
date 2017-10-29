package ru.academit.maslenkin.shapes.shapes.main;

import ru.academit.maslenkin.shapes.shapes.comparator.AreaComparator;
import ru.academit.maslenkin.shapes.shapes.comparator.PerimeterComparator;
import ru.academit.maslenkin.shapes.shapes.shapes.*;
import ru.academit.maslenkin.shapes.shapes.shapes.Rectangle;
import ru.academit.maslenkin.shapes.shapes.shapes.Shape;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by Александр on 05.10.2017.
 */
public class Main {
    public static Shape getMaxAreaShape(Shape... shape) {
        Arrays.sort(shape, new AreaComparator());
        return shape[shape.length - 1];
    }

    public static Shape getSecondPerimeter(Shape... shape) {
        Arrays.sort(shape, new PerimeterComparator());
        return shape[shape.length - 2];
    }

    public static void main(String[] args) {

        Shape shape1 = new Square(5);
        Shape shape2 = new Circle(5);
        Shape shape3 = new Rectangle(5, 8);
        Shape shape4 = new Triangle(4, 56, 7, 5, 4, 3);
        Shape shape5 = new Rectangle(7, 8);

        Shape[] shapes = {shape1, shape2, shape3, shape4, shape5};

        Shape maxArea = getMaxAreaShape(shapes);
        Shape secondPerimeter = getSecondPerimeter(shapes);
        System.out.printf("Фигура с максимальной площадью: %s.%nПлощадь фигуры равна %.2f%n", maxArea.toString(), maxArea.getArea());
        System.out.printf("Фигура с вторым по величине периметром: %s.%nПериметр фигуры равен %.2f%n", secondPerimeter.toString(), secondPerimeter.getPerimeter());
    }
}
