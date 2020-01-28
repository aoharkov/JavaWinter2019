package task2.p2;

import task2.p2.controller.BookController;
import task2.p2.model.service.BookService;
import task2.p2.model.utils.BookArrayGenerator;
import task2.p2.view.BookView;

public class BookMain {
    public static void main(String[] args) {
        new BookController(new BookService(BookArrayGenerator.generate(12)), new BookView()).run();
    }
}
