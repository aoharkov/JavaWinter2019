package task2.p2.model.service;

import task2.p2.model.domain.BookField;
import task2.p2.model.domain.Book;
import task2.p2.model.domain.QueryType;
import task2.p2.model.utils.BookArrayGenerator;

import java.util.Arrays;

public class BookService {
    private Book[] books;

    public BookService() {
        this.books = BookArrayGenerator.generate(12);
    }

    public String showBooks() {
        return BookArrayParser.parse(books);
    }

    public String processQuery(QueryType queryType, BookField bookField, String... args) {
        Book[] result = BookQueryProcessor.process(books, queryType, bookField, args);
        return BookArrayParser.parse(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookService)) return false;
        BookService that = (BookService) o;
        return Arrays.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(books);
    }
}
