package task2.p1.view;

public class ShapeView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String[] messages) {
        for (String message:
             messages) {
            System.out.println(message);
        }
    }

}
