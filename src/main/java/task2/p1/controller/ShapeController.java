package task2.p1.controller;

import task2.p1.model.service.ShapeService;
import task2.p1.view.ShapeView;

public class ShapeController {
    private ShapeService shapeService;
    private ShapeView shapeView;

    public ShapeController(ShapeService shapeService, ShapeView shapeView) {
        this.shapeService = shapeService;
        this.shapeView = shapeView;
    }

    public ShapeController() {
        this.shapeService = new ShapeService();
        this.shapeView = new ShapeView();
    }

    public void demo() {
        showData();
        showTotalArea();
        showTotalArea("Rectangle");
        sortByArea();
        sortByColour();
    }

    public void showData() {
        shapeView.printMessage("\nshowData:\n");
        shapeView.printMessage(shapeService.showData());
    }

    public void showTotalArea() {
        shapeView.printMessage("\nshowTotalArea:");
        shapeView.printMessage(shapeService.showTotalArea());
    }

    public void showTotalArea(String type) {
        shapeView.printMessage("\nshowTotalArea of type: " + type + ": ");
        shapeView.printMessage(shapeService.showTotalArea(type));
    }

    public void sortByArea() {
        shapeView.printMessage("\nshowSortedByArea:\n");
        shapeView.printMessage(shapeService.sortByArea());
    }

    public void sortByColour() {
        shapeView.printMessage("\nshowSortedByColour:\n");
        shapeView.printMessage(shapeService.sortByColour());
    }

}
