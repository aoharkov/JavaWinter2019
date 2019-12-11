package task2.p1;

import task2.p1.controller.ShapeController;
import task2.p1.model.domain.Shape;
import task2.p1.model.utils.ShapesGenerator;
import task2.p1.view.ShapeView;

public class Main {
    public static void main(String[] args) {
        ShapeController controller = new ShapeController();
        controller.showData();
        controller.showTotalArea();
        controller.showTotalArea("Rectangle");
        controller.sortByArea();
        controller.sortByColour();
    }
}
