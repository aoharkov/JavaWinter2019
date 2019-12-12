package task2.p1.model.service;

import task2.p1.model.domain.Shape;
import task2.p1.model.repository.ShapeRepository;
import task2.p1.model.utils.AreaCalculator;
import task2.p1.model.utils.ShapeAreaComparator;
import task2.p1.model.utils.ShapeColorComparator;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeService {
    private ShapeRepository repository;

    public ShapeService(ShapeRepository repository) {
        this.repository = repository;
    }

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
        Shape[] representation = sortByComparator(new ShapeAreaComparator());
        return new ShapeRepository(representation).toString();
    }

    public String sortByColour() {
        Shape[] representation = sortByComparator(new ShapeColorComparator());
        return new ShapeRepository(representation).toString();
    }

    private Shape[] sortByComparator(Comparator comparator) {
        Shape[] result = Arrays.copyOf(repository.getShapes(), repository.getShapes().length);
        Arrays.sort(result, comparator);
        return result;
    }


}