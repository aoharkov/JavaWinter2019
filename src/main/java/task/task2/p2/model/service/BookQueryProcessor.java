package task.task2.p2.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practice.Temp;
import task.task2.p2.model.domain.Book;
import task.task2.p2.model.domain.BookField;
import task.task2.p2.model.domain.QueryType;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class BookQueryProcessor {
    private static final Logger LOGGER = LogManager.getLogger(Temp.class);
    private static final String UNKNOWN_QUERY_TYPE_IN_BOOK_QUERY_PROCESSING = "Unknown queryType in book query processing";
    private static final String NO_CASE_IMPLEMENTED_FOR_SUCH_FILTER_IN_BOOK_MATCHING = "No case implemented for such filter in book matching";
    private static final String UNKNOWN_QUERY_TYPE_IN_BOOK_MATCHING = "Unknown queryType in book matching";
    private static final String UNKNOWN_BOOK_FIELD_IN_SORT_BY_QUERY = "Unknown bookField in sortByQuery";

    static Book[] process(Book[] books, QueryType queryType, BookField bookField, String... args) {
        switch (queryType) {
            case GET:
            case FILTER:
                return getByQuery(queryType, books, bookField, args);
            case SORT_BY:
                return sortByQuery(books, bookField, args);
            default:
                LOGGER.error(UNKNOWN_QUERY_TYPE_IN_BOOK_QUERY_PROCESSING);
                return new Book[0];
        }
    }

    private static boolean match(QueryType queryType, Book book, BookField bookField, String... args) {
        switch (queryType) {
            case GET:
                return book.getStrByQuery(bookField).equals(args[0]);
            case FILTER:
                if (bookField == BookField.YEAR_OF_PUBLISHING && args.length >= 2) {
                    int year = Integer.parseInt(args[0]);
                    if (args[1].equals("after")) {
                        return book.getIntByQuery(bookField) > year;
                    }
                }
                LOGGER.error(NO_CASE_IMPLEMENTED_FOR_SUCH_FILTER_IN_BOOK_MATCHING);
                break;
            default:
                LOGGER.error(UNKNOWN_QUERY_TYPE_IN_BOOK_MATCHING);
        }
        return false;
    }

    private static Book[] getByQuery(QueryType queryType, Book[] books, BookField bookField, String... args) {
        List<Book> sample = new LinkedList<>();
        for (Book book : books) {
            if (match(queryType, book, bookField, args)) {
                sample.add(book);
            }
        }
        return sample.toArray(new Book[sample.size()]);
    }

    private static Book[] sortByQuery(Book[] books, BookField bookField, String... args) {
        Book[] result = Arrays.copyOf(books, books.length);
        switch (bookField) {
            case BOOK_NAME:
            case PUBLISHER_NAME:
            case AUTHOR_NAME:
                Arrays.sort(result, (o1, o2) -> o1.getStrByQuery(bookField).compareTo(o2.getStrByQuery(bookField)));
                break;
            case PRICE:
            case NUMBER_OF_PAGES:
            case YEAR_OF_PUBLISHING:
                Arrays.sort(result, (o1, o2) -> o1.getIntByQuery(bookField) - o2.getIntByQuery(bookField));
                break;
            default:
                LOGGER.error(UNKNOWN_BOOK_FIELD_IN_SORT_BY_QUERY);
                return new Book[0];
        }
        return result;
    }
}
