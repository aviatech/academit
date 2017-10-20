package ru.academit.maslenkin.shapes.shapes.shapes;

/**
 * Created by Александр on 12.10.2017
 */
public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle" + "[" + width + "]" + "[" + height + "]" + "Area" + " = " + getArea();
    }

    @Override
    public int hashCode() {
        int prime = 33;
        int resultHash = 1;
        resultHash = prime * resultHash + (int) height;
        resultHash = prime * resultHash + (int) width;
        return resultHash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) obj;
        return (width == rectangle.width && height == rectangle.height);

    }
}
