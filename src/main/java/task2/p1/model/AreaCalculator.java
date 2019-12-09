package task2.p1.model;

public class AreaCalculator {
    public static int calculateTotalArea(Shape[] shapes) {
        int totalArea = 0;
        for (Shape shape :
                shapes) {
            totalArea += shape.calcArea();
        }
        return totalArea;
    }

    public static int calculateTotalArea(Shape[] shapes, String type) {
        return 0;
    }
}
