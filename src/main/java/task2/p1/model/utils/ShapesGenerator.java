package task2.p1.model.utils;

import task2.p1.model.domain.Circle;
import task2.p1.model.domain.Rectangle;
import task2.p1.model.domain.Shape;
import task2.p1.model.domain.Triangle;

public class ShapesGenerator {
    public static Shape[] generateShapes(int num) {
        Shape[] shapes = new Shape[num];
        for (int i = 0; i < num; i++) {
            String colour;
            switch (i % 4) {
                case 1 : colour = "green"; break;
                case 2 : colour = "blue"; break;
                case 3 : colour = "yellow"; break;
                default: colour = "red";
            }
            switch (i % 3) {
                case 1 : shapes[i] = new Triangle(colour, i + 1, i + 1, i + 1); break;
                case 2 : shapes[i] = new Circle(colour, i + 1); break;
                default: shapes[i] = new Rectangle(colour, i + 1, i + 1);
            }
        }
        return shapes;
    }
}
