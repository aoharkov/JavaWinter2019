package task2.p2;

import task2.p2.controller.BookController;
import task2.p2.model.service.BookService;
import task2.p2.view.BookView;

public class Main {
    public static void main(String[] args) {
        new BookController().run();
    }
}
