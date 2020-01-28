package task.task3.p1;

import task.task3.p1.controller.ToyController;
import task.task3.p1.view.ToyView;

public class ToyMain {
    public static void main(String[] args) {
        new ToyController(new ToyView()).run();
    }
}
