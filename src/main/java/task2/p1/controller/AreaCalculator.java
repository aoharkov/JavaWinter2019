package task2.p1.controller;

import task2.p1.model.Shape;

class AreaCalculator {
    static double calculateTotalArea(Shape[] shapes) {
        double totalArea = 0.0; //better to initialise with double literal 0.0
        for (Shape shape :
                shapes) {
            totalArea += shape.calcArea();
        }
        return totalArea;
    }

    static double calculateTotalArea(Shape[] shapes, String type) {
        double totalArea = 0.0;
        for (Shape shape :
                shapes) {
            if (shape.getClass().getSimpleName().equals(type)) {
                totalArea += shape.calcArea();
            }
        }
        return totalArea;
    }
}
