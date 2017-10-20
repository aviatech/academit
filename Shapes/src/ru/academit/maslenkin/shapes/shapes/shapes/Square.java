package ru.academit.maslenkin.shapes.shapes.shapes;

/**
 * Created by Александр on 05.10.2017.
 */
public class Square implements Shape {
    private double width;
    private static final int SIDE = 4;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return width;
    }

    @Override
    public double getArea() {
        return width * width;
    }

    @Override
    public double getPerimeter() {
        return width * SIDE;
    }

    @Override
    public String toString() {
        return "Square" + "[" + width + "]";
    }

    @Override
    public int hashCode() {
        int prime = 33;
        int resultHash = 1;
        resultHash = prime * resultHash + (int) width;
        return resultHash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Square)) return false;
        Square square = (Square) obj;
        return (width == square.width);

    }
}
