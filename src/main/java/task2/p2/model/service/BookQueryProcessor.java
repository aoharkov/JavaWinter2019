package task2.p2.model.service;

import task2.p2.model.domain.BookField;
import task2.p2.model.domain.Book;
import task2.p2.model.domain.QueryType;

import java.util.Arrays;
import java.util.Comparator;

class BookQueryProcessor {
    static Book[] process(Book[] books, QueryType queryType, BookField bookField, String... args) {
        switch (queryType) {
            case GET:
            case FILTER:
                return getByQuery(queryType, books, bookField, args);
            case SORT_BY:
                return sortByQuery(books, bookField, args);
            default:
                System.out.println("Unknown queryType in book query processing");
                return null;
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
                System.out.println("No case implemented for such filter in book matching");
                break;
            default:
                System.out.println("Unknown queryType in book matching");
        }
        return false;
    }


    private static Book[] getByQuery(QueryType queryType, Book[] books, BookField bookField, String... args) {
        boolean[] matched = new boolean[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (match(queryType, books[i], bookField, args)) {
                matched[i] = true;
                counter++;
            }
        }
        Book[] sample = new Book[counter];
        counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (matched[i]) {
                sample[counter] = books[i];
                counter++;
            }
        }
        return sample;
    }

    private static Book[] sortByQuery(Book[] books, BookField bookField, String... args) {
        Book[] result = Arrays.copyOf(books, books.length);
        switch (bookField) {
            case BOOK_NAME:
            case PUBLISHER_NAME:
            case AUTHOR_NAME:
                Arrays.sort(result, new Comparator<Book>() {
                            @Override
                            public int compare(Book o1, Book o2) {
                                return o1.getStrByQuery(bookField).compareTo(o2.getStrByQuery(bookField));
                            }
                        }
                );
                break;
            case PRICE:
            case NUMBER_OF_PAGES:
            case YEAR_OF_PUBLISHING:
                Arrays.sort(result, new Comparator<Book>() {
                            @Override
                            public int compare(Book o1, Book o2) {
                                return o1.getIntByQuery(bookField) - o2.getIntByQuery(bookField);
                            }
                        }
                );
                break;
            default:
                System.out.println("Unknown bookField in sortByQuery");
                return null;
        }
        return result;
    }

}
