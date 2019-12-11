package task2.p1.model;

import task2.p1.model.Shape;

public class Triangle extends Shape {
    private double w;
    private double h;

    public Triangle(String color, double w, double h) {
        super(color);
        this.w = w;
        this.h = h;
    }

    @Override
    public double calcArea() {
        return w * h / 2.0;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", w = " + w + ", h = " + h;
    }
}
