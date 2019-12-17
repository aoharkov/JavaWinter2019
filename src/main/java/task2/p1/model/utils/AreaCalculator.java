package task2.p1.model.utils;

import task2.p1.model.entity.Shape;

public class AreaCalculator {
    public static double calculateTotalArea(Shape[] shapes) {
        double totalArea = 0.0; //better to initialise with double literal 0.0
        for (Shape shape :
                shapes) {
            totalArea += shape.calcArea();
        }
        return totalArea;
    }

    public static double calculateTotalArea(Shape[] shapes, String type) {
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
