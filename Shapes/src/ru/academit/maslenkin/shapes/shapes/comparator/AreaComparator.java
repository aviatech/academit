package ru.academit.maslenkin.shapes.shapes.comparator;

import ru.academit.maslenkin.shapes.shapes.shapes.Shape;

import java.util.Comparator;

/**
 * Created by Александр on 20.10.2017.
 */
public class AreaComparator implements Comparator<Shape> {

    public int compare(Shape o1, Shape o2) {
        double area1 = o1.getArea();
        double area2 = o2.getArea();
        return Double.compare(area1, area2);
    }

}
