package task.task2.p1.controller;

import task.task2.p1.model.entity.ShapeType;
import task.task2.p1.model.service.ShapeService;
import task.task2.p1.view.ShapeInputData;
import task.task2.p1.view.ShapeView;

public class ShapeController implements Runnable {

    private ShapeService shapeService;
    private ShapeView shapeView;

    public ShapeController(ShapeService shapeService, ShapeView shapeView) {
        this.shapeService = shapeService;
        this.shapeView = shapeView;
    }

    @Override
    public void run() {
        showData();
        showTotalArea();
        chooseTypeForShowingTotalArea();
        chooseCriteriaForSorting();
        readShapeFromConsole();
    }

    private void readShapeFromConsole() {
        shapeView.printMessage(ShapeView.ENTER_THE_SHAPE);
        System.out.println(ShapeParser.parse(ShapeInputData.nextLine()));
    }

    private void showData() {
        shapeView.printMessage(ShapeView.SHOW_DATA);
        shapeView.printMessage(shapeService.showData());
    }

    private void showTotalArea() {
        shapeView.printMessage(ShapeView.SHOW_TOTAL_AREA);
        shapeView.printMessage(shapeService.showTotalArea());
    }

    private void chooseTypeForShowingTotalArea() {
        shapeView.printMessage(ShapeView.ENTER_THE_TYPE_OF_SORTING);
        ShapeType shapeType = ShapeType.valueOf(ShapeInputData.next().toUpperCase());
        switch (shapeType) {
            case RECTANGLE:
            case TRIANGLE:
            case CIRCLE:
                showTotalArea(shapeType.name());
                break;
            default:
                shapeView.printMessage(ShapeView.INVALID_TYPE);
        }
    }

    private void chooseCriteriaForSorting() {
        shapeView.printMessage(ShapeView.ENTER_THE_CRITERIA_OF_SORTING);
        String criteria = ShapeInputData.next().toLowerCase();
        switch (criteria) {
            case ShapeView.AREA:
                sortByArea();
                break;
            case ShapeView.COLOR:
                sortByColour();
                break;
            default:
                shapeView.printMessage(ShapeView.INVALID_CRITERIA);
        }
    }

    private void showTotalArea(String type) {
        shapeView.printMessage(String.format(ShapeView.SHOW_TOTAL_AREA_OF_TYPE, type));
        shapeView.printMessage(shapeService.showTotalArea(type));
    }

    private void sortByArea() {
        shapeView.printMessage(ShapeView.SHOW_SORTED_BY_AREA);
        shapeView.printMessage(shapeService.sortByArea());
    }

    private void sortByColour() {
        shapeView.printMessage(ShapeView.SHOW_SORTED_BY_COLOUR);
        shapeView.printMessage(shapeService.sortByColour());
    }
}
