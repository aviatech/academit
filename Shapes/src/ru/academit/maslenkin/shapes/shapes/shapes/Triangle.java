package ru.academit.maslenkin.shapes.shapes.shapes;

/**
 * Created by Александр on 08.10.2017.
 */
public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    private static double getLengthSide(double x1, double x2, double y1, double y2) {
        return (Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
    }

    @Override
    public double getWidth() {
        double max = Math.max(x1, x2);
        double min = Math.min(x1, x2);
        return Math.max(max, x3) - Math.min(min, x3);
    }

    @Override
    public double getHeight() {
        double max = Math.max(y1, y2);
        double min = Math.min(y1, y2);
        return Math.max(max, y3) - Math.min(min, y3);
    }

    @Override
    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - getLengthSide(x1, x2, y1, y2)) + (semiPerimeter - getLengthSide(x2, x3, y2, y3)) + (semiPerimeter - getLengthSide(x1, x3, y1, y3)));
    }

    @Override
    public double getPerimeter() {
        return getLengthSide(x1, x2, y1, y2) + getLengthSide(x2, x3, y2, y3) + getLengthSide(x1, x3, y1, y3);
    }

    @Override
    public String toString() {
        return "Triangle" + "[" + x1 + " " + y1 + "]" + "[" + x2 + " " + y2 + "]" + "[" + x3 + " " + y3 + "]" + "Area = " + getArea();
    }

    @Override
    public int hashCode() {
        int prime = 33;
        int resultHash = 1;
        resultHash = prime * resultHash + (int) x1;
        resultHash = prime * resultHash + (int) y1;
        resultHash = prime * resultHash + (int) x2;
        resultHash = prime * resultHash + (int) y2;
        resultHash = prime * resultHash + (int) x3;
        resultHash = prime * resultHash + (int) y3;
        return resultHash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Triangle)) return false;
        Triangle triangle = (Triangle) obj;
        return (x1 == triangle.x1 && y1 == triangle.y1 && x2 == triangle.x2 && y2 == triangle.y2 && x3 == triangle.y3);

    }
}
