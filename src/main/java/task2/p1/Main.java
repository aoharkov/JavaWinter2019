package task2.p1;

import task2.p1.controller.ShapeController;
import task2.p1.model.Shape;
import task2.p1.controller.ShapesGenerator;
import task2.p1.view.ShapeView;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = ShapesGenerator.generateShapes(12);
        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(shapes, view);
        controller.showData();
        controller.showTotalArea();
        controller.showTotalArea("Rectangle");
        controller.sortByArea();
        controller.showData();
        System.out.println();
        controller.sortByColour();
        controller.showData();
    }
}
