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
        showBooksOfAuthor("Author1");
        showBooksOfPublisher("Publisher1");
        showBooksOfYearAfter(1995);
    }

    public void showBooks() {
        view.update(service.showBooks());
    }

    public void showBooksOfAuthor(String authorName) {
        view.update(service.showBooksOfAuthor(authorName));
    }

    public void showBooksOfPublisher(String publisherName) {
        view.update(service.showBooksOfPublisher(publisherName));
    }

    public void showBooksOfYearAfter(int year) {
        view.update(service.showBooksOfYearAfter(year));
    }

}
