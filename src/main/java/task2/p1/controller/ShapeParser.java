package task2.p1.controller;

import task2.p1.model.entity.Circle;
import task2.p1.model.entity.Rectangle;
import task2.p1.model.entity.Shape;
import task2.p1.model.entity.ShapeType;
import task2.p1.model.entity.Triangle;

public class ShapeParser {
    public static Shape parse(String shape) {
        String strType = shape.substring(0, shape.indexOf(":")).toUpperCase();
        ShapeType shapeType = ShapeType.valueOf(strType);
        switch (shapeType) {
            case CIRCLE:
                return Circle.parseShape(shape);
            case TRIANGLE:
                return Triangle.parseShape(shape);
            case RECTANGLE:
                return Rectangle.parseShape(shape);
        }
        return null;
    }
}
