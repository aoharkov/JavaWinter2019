package task2.p2.model.service;

import org.junit.Test;
import task2.p2.model.domain.Book;
import task2.p2.model.domain.BookField;
import task2.p2.model.domain.QueryType;
import task2.p2.model.utils.BookArrayGenerator;
import task2.p2.model.utils.BookGenerator;

import static org.junit.Assert.*;

public class BookQueryProcessorTest {
    private Book[] books = BookArrayGenerator.generate(6);

    @Test
    public void process() {
        Book[] expected = new Book[2];
        expected[0] = BookGenerator.generate(1);
        expected[1] = BookGenerator.generate(5);
        assertArrayEquals(expected,
                BookQueryProcessor.process(
                        books, QueryType.GET,
                        BookField.AUTHOR_NAME, "Author1"));
    }
}