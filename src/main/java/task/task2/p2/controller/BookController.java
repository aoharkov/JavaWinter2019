package task.task2.p2.controller;

import task.task2.p2.model.domain.BookField;
import task.task2.p2.model.domain.QueryType;
import task.task2.p2.model.service.BookService;
import task.task2.p2.view.BookInputData;
import task.task2.p2.view.BookView;

public class BookController implements Runnable {
    private static final String AFTER = "after";

    private BookService service;
    private BookView view;

    public BookController(BookService service, BookView view) {
        this.service = service;
        this.view = view;
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
        view.viewData(service.showBooks());
    }

    private void showSortedBooksByPublisher() {
        view.viewData(BookView.BOOKS_SORTED_BY_PUBLISHER
                + service.processQuery(QueryType.SORT_BY, BookField.PUBLISHER_NAME));
    }

    private void showBooksOfAuthor() {
        view.viewData(BookView.ENTER_NAME_OF_AUTHOR_FOR_SEARCH);
        String authorName = BookInputData.input();
        view.viewData(String.format(BookView.BOOKS_OF, authorName,
                service.processQuery(QueryType.GET, BookField.AUTHOR_NAME, authorName)));
    }

    private void showBooksOfPublisher() {
        view.viewData(BookView.ENTER_NAME_OF_PUBLISHER_FOR_SEARCH);
        String publisherName = BookInputData.input();
        view.viewData(String.format(BookView.BOOKS_OF, publisherName,
                service.processQuery(QueryType.GET, BookField.PUBLISHER_NAME, publisherName)));
    }

    private void filterBooksOfYearAfter() {
        view.viewData(BookView.ENTER_YEAR_AFTER_TO_FILTER);
        int year = Integer.parseInt(BookInputData.input());
        view.viewData(String.format(BookView.BOOKS_AFTER, year,
                service.processQuery(QueryType.FILTER, BookField.YEAR_OF_PUBLISHING,
                        Integer.toString(year), AFTER)));
    }
}
