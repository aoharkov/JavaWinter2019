package task2.p1.view;

public class ShapeView {
    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessage(String[] messages) {
        for (String message:
             messages) {
            System.out.print(message);
        }
    }

    public void printTotalArea(double totalArea) {
        System.out.println(String.format("Total area: %.2f", totalArea));
    }

}
