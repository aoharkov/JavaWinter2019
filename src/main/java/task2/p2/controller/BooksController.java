package task2.p2.controller;

import task2.p2.model.service.BooksService;
import task2.p2.view.BooksView;

public class BooksController {
    private BooksService service;
    private BooksView view;

    public BooksController(BooksService service, BooksView view) {
        this.service = service;
        this.view = view;
    }

    public void demo() {
        showBooks();
    }

    public void showBooks() {
        view.update(service.showBooks());
    }
}
