package ru.academit.maslenkin.shapes.shapes.shapes;

/**
 * Created by Александр on 05.10.2017.
 */
public class Square implements Shape {
    private double width;


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
        int side = 4;
        return width * side;
    }
}
