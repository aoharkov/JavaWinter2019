package task2.p2;

import task2.p2.controller.BookController;
import task2.p2.model.service.BookService;
import task2.p2.view.BookView;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        BookView bookView = new BookView();
        BookController bookController = new BookController(bookService, bookView);
        bookController.demo();
    }
}
