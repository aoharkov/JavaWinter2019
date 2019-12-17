package task2.p1.model.repository;

import task2.p1.model.entity.Shape;
import task2.p1.model.utils.ShapesGenerator;

public class ShapeRepository {
    private Shape[] shapes;

    public ShapeRepository(Shape[] shapes) {
        this.shapes = shapes;
    }

    public ShapeRepository() {
        this.shapes = ShapesGenerator.generateShapes(12);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Shape shape : shapes) {
            str.append(shape.draw());
        }
        return str.toString();
    }

    public Shape[] getShapes() {
        return shapes;
    }

    public void setShapes(Shape[] shapes) {
        this.shapes = shapes;
    }
}
