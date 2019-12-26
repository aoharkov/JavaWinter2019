package task2.p2.model.service;

import org.junit.Test;
import task2.p2.model.domain.Book;
import task2.p2.model.domain.BookField;
import task2.p2.model.domain.QueryType;
import task2.p2.model.utils.BookArrayGenerator;
import task2.p2.model.utils.BookGenerator;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService service;

    public BookServiceTest() {
        this.service = new BookService();
    }

    @Test
    public void showBooks() {
        Book[] books = BookArrayGenerator.generate(12);
        String expected = BookArrayParser.parse(books);
        assertEquals(expected, BookArrayParser.parse(books));
    }

    @Test
    public void processQuery() {
        Book[] expected = new Book[3];
        expected[0] = BookGenerator.generate(1);
        expected[1] = BookGenerator.generate(5);
        expected[2] = BookGenerator.generate(9);
        assertEquals(BookArrayParser.parse(expected),
                service.processQuery(QueryType.GET, BookField.AUTHOR_NAME, "Author1"));
    }
}