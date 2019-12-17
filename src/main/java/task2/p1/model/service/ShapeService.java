package task2.p1.model.service;

import task2.p1.model.entity.Shape;
import task2.p1.model.repository.ShapeRepository;
import task2.p1.model.utils.AreaCalculator;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeService {
    private ShapeRepository repository;

    public ShapeService() {
        this.repository = new ShapeRepository();
    }

    public String  showData() {
        return repository.toString();
    }

    public double showTotalArea() {
        return AreaCalculator.calculateTotalArea(repository.getShapes());
    }

    public double showTotalArea(String type) {
        return AreaCalculator.calculateTotalArea(repository.getShapes(), type);
    }

    public String sortByArea() {
        Shape[] representation = sortByComparator(new Comparator<Shape>() {
            @Override
            public int compare(Shape shape1, Shape shape2) {
                return (int) (shape1.calcArea() - shape2.calcArea());
            }
        });
        return new ShapeRepository(representation).toString();
    }

    public String sortByColour() {
        Shape[] representation = sortByComparator(new Comparator<Shape>() {
            @Override
            public int compare(Shape shape1, Shape shape2) {
                return shape1.getShapeColor().compareTo(shape2.getShapeColor());
            }
        });
        return new ShapeRepository(representation).toString();
    }

    private Shape[] sortByComparator(Comparator comparator) {
        Shape[] result = Arrays.copyOf(repository.getShapes(), repository.getShapes().length);
        Arrays.sort(result, comparator);
        return result;
    }


}
