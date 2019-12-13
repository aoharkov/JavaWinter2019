package task2.p2.controller;

import task2.p2.model.service.BookService;
import task2.p2.view.BookView;

public class BookController {
    private BookService service;
    private BookView view;

    public BookController(BookService service, BookView view) {
        this.service = service;
        this.view = view;
    }

    public void demo() {
        showBooks();
        showBooksOfAuthor("Author1");
        showBooksOfPublisher("Publisher1");
        showBooksOfYearAfter(1995);
        showSortedBooksByPublisher();
    }

    public void showBooks() {
        view.update(service.showBooks() + "\n");
    }

    public void showBooksOfAuthor(String authorName) {
        view.update("Books of " + authorName + "\n"
                + service.showBooksOfAuthor(authorName) + "\n");
    }

    public void showBooksOfPublisher(String publisherName) {
        view.update("Books of " + publisherName + "\n"
                + service.showBooksOfPublisher(publisherName) + "\n");
    }

    public void showBooksOfYearAfter(int year) {
        view.update("Books after " + year + "\n"
                + service.showBooksOfYearAfter(year) + "\n");
    }

    public void showSortedBooksByPublisher() {
        view.update("Books sorted by publisher\n"
                + service.sortByPublisher() + "\n");
    }


}
