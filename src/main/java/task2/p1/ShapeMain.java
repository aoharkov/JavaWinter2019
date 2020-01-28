package task2.p1;

import task2.p1.controller.ShapeController;
import task2.p1.model.repository.ShapeRepository;
import task2.p1.model.service.ShapeService;
import task2.p1.view.ShapeView;

public class ShapeMain {
    public static void main(String[] args) {
        new ShapeController(new ShapeService(new ShapeRepository()), new ShapeView()).run();
    }
}
