package ru.academit.maslenkin.shapes.shapes.shapes;

/**
 * Created by Александр on 08.10.2017.
 */
public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return radius + radius;
    }

    @Override
    public double getHeight() {
        return radius + radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle" + "[" + radius + "]";
    }

    @Override
    public int hashCode() {
        int prime = 33;
        int resultHash = 1;
        resultHash = prime * resultHash + (int) radius;
        return resultHash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Circle circle = (Circle) o;
        return radius == circle.radius;

    }
}
