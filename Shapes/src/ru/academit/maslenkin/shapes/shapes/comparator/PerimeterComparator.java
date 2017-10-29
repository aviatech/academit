package ru.academit.maslenkin.shapes.shapes.comparator;

import ru.academit.maslenkin.shapes.shapes.shapes.Shape;

import java.util.Comparator;

/**
 * Created by Александр on 29.10.2017.
 */
public class PerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        double perimeter1 = o1.getPerimeter();
        double perimeter2 = o2.getPerimeter();
        return Double.compare(perimeter1, perimeter2);
    }
}
