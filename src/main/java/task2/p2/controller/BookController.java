package task2.p2.controller;

import task2.p2.model.service.BookService;
import task2.p2.view.BookInputData;
import task2.p2.view.BookView;

public class BookController implements Runnable {
    private BookService service;
    private BookView view;

    public BookController() {
        this.service = new BookService();
        this.view = new BookView();
    }

    @Override
    public void run() {
        showBooks();
        showSortedBooksByPublisher();
        showBooksOfAuthor();
        showBooksOfPublisher();
        showBooksOfYearAfter();
    }

    private void showBooks() {
        view.viewData(service.showBooks() + "\n");
    }

    private void showSortedBooksByPublisher() {
        view.viewData("Books sorted by publisher\n"
                + service.sortByPublisher() + "\n");
    }

    private void showBooksOfAuthor() {
        view.viewData("\nEnter name of author for search -> ");
        String authorName = BookInputData.input();
        view.viewData("Books of " + authorName + "\n"
                + service.showBooksOfAuthor(authorName) + "\n");
    }

    private void showBooksOfPublisher() {
        view.viewData("\nEnter name of publisher for search -> ");
        String publisherName = BookInputData.input();
        view.viewData("Books of " + publisherName + "\n"
                + service.showBooksOfPublisher(publisherName) + "\n");
    }

    private void showBooksOfYearAfter() {
        view.viewData("\nEnter year for search after-> ");
        int year = Integer.parseInt(BookInputData.input());
        view.viewData("Books after " + year + "\n"
                + service.showBooksOfYearAfter(year) + "\n");
    }

}
