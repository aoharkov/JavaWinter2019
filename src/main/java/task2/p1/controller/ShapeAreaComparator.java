package task2.p1.controller;

import task2.p1.model.Shape;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Shape shape1 = (Shape) o1;
        Shape shape2 = (Shape) o2;
        return (int) (shape1.calcArea() - shape2.calcArea());
    }
}
