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

    public void printTotalArea(int totalArea) {
        System.out.println("Total area: " + totalArea);
    }

}
