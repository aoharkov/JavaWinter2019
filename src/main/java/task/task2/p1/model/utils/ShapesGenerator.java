package task.task2.p1.model.utils;

import task.task2.p1.model.entity.Circle;
import task.task2.p1.model.entity.Rectangle;
import task.task2.p1.model.entity.Shape;
import task.task2.p1.model.entity.Triangle;

public class ShapesGenerator {
    public static Shape[] generateShapes(int num) {
        Shape[] shapes = new Shape[num];
        for (int i = 0; i < num; i++) {
            String colour;
            switch (i % 4) {
                case 1:
                    colour = "green";
                    break;
                case 2:
                    colour = "blue";
                    break;
                case 3:
                    colour = "yellow";
                    break;
                default:
                    colour = "red";
            }
            switch (i % 3) {
                case 1:
                    shapes[i] = new Triangle(colour, i + 1.0, i + 1.0, i + 1.0);
                    break;
                case 2:
                    shapes[i] = new Circle(colour, i + 1.0);
                    break;
                default:
                    shapes[i] = new Rectangle(colour, i + 1.0, i + 1.0);
            }
        }
        return shapes;
    }
}
