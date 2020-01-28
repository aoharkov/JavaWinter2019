package task.task2.p1;

import task.task2.p1.controller.ShapeController;
import task.task2.p1.model.repository.ShapeRepository;
import task.task2.p1.model.service.ShapeService;
import task.task2.p1.view.ShapeView;

public class ShapeMain {
    public static void main(String[] args) {
        new ShapeController(new ShapeService(new ShapeRepository()), new ShapeView()).run();
    }
}
