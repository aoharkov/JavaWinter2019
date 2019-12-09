package task2.p1.controller;

import task2.p1.model.Shape;

class AreaCalculator {
    static int calculateTotalArea(Shape[] shapes) {
        int totalArea = 0;
        for (Shape shape :
                shapes) {
            totalArea += shape.calcArea();
        }
        return totalArea;
    }

    static int calculateTotalArea(Shape[] shapes, String type) {
        int totalArea = 0;
        for (Shape shape :
                shapes) {
            if (shape.getClass().getSimpleName().equals(type)) {
                totalArea += shape.calcArea();
            }
        }
        return totalArea;
    }
}
