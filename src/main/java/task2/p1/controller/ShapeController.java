package task2.p1.controller;

import task2.p1.model.*;
import task2.p1.view.ShapeView;


public class ShapeController {
    private Shape[] shapes;
    private ShapeView shapeView;
    
    public ShapeController(Shape[] shapes, ShapeView shapeView) {
        this.shapes = shapes;
        this.shapeView = shapeView;
    }

    public void showData() {
        String[] lines = new String[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            lines[i] = shapes[i].draw();
        }
        shapeView.printMessage(lines);
    }

    public void showTotalArea() {
        shapeView.printTotalArea(AreaCalculator.calculateTotalArea(shapes));
    }

    public void showTotalArea(String type) {
        shapeView.printTotalArea(AreaCalculator.calculateTotalArea(shapes, type));
    }

    public Shape[] sortByArea() {
        return null;
    }

    public Shape[] sortByColour() {
        return null;
    }

}
