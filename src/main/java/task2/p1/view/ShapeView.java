package task2.p1.view;

public class ShapeView {
    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessage(double totalArea) {
        System.out.print(String.format("%.2f\n", totalArea));
    }

}
