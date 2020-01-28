package task.task2.p1.model.service;

import task.task2.p1.model.entity.Shape;
import task.task2.p1.model.repository.ShapeRepository;
import task.task2.p1.model.utils.AreaCalculator;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeService {
    private ShapeRepository repository;

    public ShapeService(ShapeRepository repository) {
        this.repository = repository;
    }

    public String showData() {
        return repository.toString();
    }

    public double showTotalArea() {
        return AreaCalculator.calculateTotalArea(repository.getShapes());
    }

    public double showTotalArea(String type) {
        return AreaCalculator.calculateTotalArea(repository.getShapes(), type);
    }

    public String sortByArea() {
        Shape[] representation = sortByComparator((Comparator<Shape>) (shape1, shape2) -> (int) (shape1.calcArea() - shape2.calcArea()));
        return new ShapeRepository(representation).toString();
    }

    public String sortByColour() {
        Shape[] representation = sortByComparator((Comparator<Shape>) (shape1, shape2) -> shape1.getShapeColor().compareTo(shape2.getShapeColor()));
        return new ShapeRepository(representation).toString();
    }

    private Shape[] sortByComparator(Comparator comparator) {
        Shape[] result = Arrays.copyOf(repository.getShapes(), repository.getShapes().length);
        Arrays.sort(result, comparator);
        return result;
    }
}
