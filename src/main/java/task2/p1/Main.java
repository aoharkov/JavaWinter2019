package task2.p1;

import task2.p1.model.Rectangle;
import task2.p1.model.Shape;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle("red", 10, 4);
        rectangle.draw();
    }
}
