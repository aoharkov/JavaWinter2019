package task2.p1.controller;

import task2.p1.model.Circle;
import task2.p1.model.Rectangle;
import task2.p1.model.Shape;
import task2.p1.model.Triangle;
import task2.p1.view.ShapeView;


public class ShapeController {
    private Shape[] shapes;
    private ShapeView shapeView;
    
    public ShapeController(Shape[] shapes, ShapeView shapeView) {
        this.shapes = shapes;
        this.shapeView = shapeView;
    }

    public void printData() {
        String[] lines = new String[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            lines[i] = shapes[i].draw();
        }
        shapeView.printMessage(lines);
    }

    public Shape[] generateData() {
        int lenght = 12;
        Shape[] shapes = new Shape[lenght];
        for (int i = 0; i < lenght; i++) {
            String colour;
            switch (i % 4) {
                case 1 : colour = "green"; break;
                case 2 : colour = "blue"; break;
                case 3 : colour = "yellow"; break;
                default: colour = "red";
            }
            switch (i % 3) {
                case 1 : shapes[i] = new Triangle(colour, i + 1, i + 1); break;
                case 2 : shapes[i] = new Circle(colour, i + 1); break;
                default: shapes[i] = new Rectangle(colour, i + 1, i + 1);
            }
        }
        return shapes;
    }

    public int totalArea() {
        return 0;
    }

    public int totalArea(String type) {
        return 0;
    }

    public Shape[] sortByArea() {
        return null;
    }

    public Shape[] sortByColour() {
        return null;
    }

}
