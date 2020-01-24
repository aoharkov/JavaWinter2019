package task2.p2.controller;

import task2.p2.model.domain.BookField;
import task2.p2.model.domain.QueryType;
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
        demo1();
    }

    private void demo1() {
        showBooks();
        showSortedBooksByPublisher();
        showBooksOfAuthor();
        showBooksOfPublisher();
        filterBooksOfYearAfter();
    }

    private void showBooks() {
        view.viewData(service.showBooks() + "\n");
    }

    private void showSortedBooksByPublisher() {
        view.viewData("Books sorted by publisher\n"
                + service.processQuery(QueryType.SORT_BY, BookField.PUBLISHER_NAME) + "\n");
    }

    private void showBooksOfAuthor() {
        view.viewData("\nEnter name of author for search -> ");
        String authorName = BookInputData.input();
        view.viewData("Books of " + authorName + "\n"
                + service.processQuery(QueryType.GET, BookField.AUTHOR_NAME, authorName) + "\n");
    }

    private void showBooksOfPublisher() {
        view.viewData("\nEnter name of publisher for search -> ");
        String publisherName = BookInputData.input();
        view.viewData("Books of " + publisherName + "\n"
                + service.processQuery(QueryType.GET, BookField.PUBLISHER_NAME, publisherName) + "\n");
    }

    private void filterBooksOfYearAfter() {
        view.viewData("\nEnter year after to filter-> ");
        int year = Integer.parseInt(BookInputData.input());
        view.viewData("Books after " + year + "\n"
                + service.processQuery(QueryType.FILTER, BookField.YEAR_OF_PUBLISHING,
                Integer.toString(year), "after")
                + "\n");
    }
}
