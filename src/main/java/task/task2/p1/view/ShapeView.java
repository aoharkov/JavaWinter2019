package task.task2.p1.view;

public class ShapeView {
    public static final String ENTER_THE_SHAPE = "\nPlease enter the Shape in the following format: Circle:red,10 -> ";
    public static final String SHOW_DATA = "\nShow data:\n";
    public static final String SHOW_TOTAL_AREA = "\nShow total area: ";
    public static final String ENTER_THE_TYPE_OF_SORTING = "\nPlease enter the type of sorting (Rectangle, Triangle, Circle) -> ";
    public static final String INVALID_TYPE = "\nInvalid type!!!\n";
    public static final String ENTER_THE_CRITERIA_OF_SORTING = "\nPlease enter the criteria of sorting (area, color) -> ";
    public static final String AREA = "area";
    public static final String COLOR = "color";
    public static final String INVALID_CRITERIA = "\nInvalid criteria!!!\n";
    public static final String SHOW_TOTAL_AREA_OF_TYPE = "\nShow total area of type (%s): ";
    public static final String SHOW_SORTED_BY_AREA = "\nShow sorted by area:\n";
    public static final String SHOW_SORTED_BY_COLOUR = "\nShow sorted by colour:\n";

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessage(double totalArea) {
        System.out.print(String.format("%.2f\n", totalArea));
    }
}
