package task2.p1.controller;

import task2.p1.model.service.ShapeService;
import task2.p1.view.ShapeInputData;
import task2.p1.view.ShapeView;

public class ShapeController implements Runnable {
    private ShapeService shapeService;
    private ShapeView shapeView;

    public ShapeController() {
        this.shapeService = new ShapeService();
        this.shapeView = new ShapeView();
    }

    @Override
    public void run() {
        showData();
        showTotalArea();
        chooseTypeForShowingTotalArea();
        chooseCriteriaForSorting();
        readShapeFromConsole();
    }

    private void readShapeFromConsole(){
        shapeView.printMessage("\nPlease enter the Shape in following format: Circle:red, 10 -> ");
        System.out.println(ShapeParser.parse(ShapeInputData.nextLine()));
    }

    private void showData() {
        shapeView.printMessage("\nShow data:\n");
        shapeView.printMessage(shapeService.showData());
    }

    private void showTotalArea() {
        shapeView.printMessage("\nShow total area: ");
        shapeView.printMessage(shapeService.showTotalArea());
    }

    private void chooseTypeForShowingTotalArea() {
        shapeView.printMessage("\nPlease enter the type of sorting (Rectangle, Triangle, Circle) -> ");
        String type = ShapeInputData.next();
        switch (type) {
            case "Rectangle":
            case "Triangle":
            case "Circle":
                showTotalArea(type); break;
            default:
                shapeView.printMessage("\nInvalid type!!!\n");
        }
    }

    private void chooseCriteriaForSorting() {
        shapeView.printMessage("\nPlease enter the criteria of sorting (area, color) -> ");
        String criteria = ShapeInputData.next().toLowerCase();
        switch (criteria) {
            case "area":
                sortByArea();
                break;
            case "color":
                sortByColour();
                break;
            default:
                shapeView.printMessage("\nInvalid criteria!!!\n");
        }
    }

    private void showTotalArea(String type) {
        shapeView.printMessage("\nShow total area of type (" + type + "): ");
        shapeView.printMessage(shapeService.showTotalArea(type));
    }

    private void sortByArea() {
        shapeView.printMessage("\nShow sorted by area:\n");
        shapeView.printMessage(shapeService.sortByArea());
    }

    private void sortByColour() {
        shapeView.printMessage("\nShow sorted by colour:\n");
        shapeView.printMessage(shapeService.sortByColour());
    }

}
