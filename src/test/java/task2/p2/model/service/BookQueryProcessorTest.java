package task2.p2.model.service;

import org.junit.Test;
import org.junit.runners.Parameterized;
import task2.p2.model.domain.Book;
import task2.p2.model.domain.BookField;
import task2.p2.model.domain.QueryType;
import task2.p2.model.utils.BookArrayGenerator;
import task2.p2.model.utils.BookGenerator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class BookQueryProcessorTest {
    private Book[] books = BookArrayGenerator.generate(6);
/*    @Parameterized.Parameter
    public Book[] expected;
    @Parameterized.Parameter(1)
    public QueryType queryType;
    @Parameterized.Parameter(2)
    public BookField bookField;
    @Parameterized.Parameter(3)
    public String name;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {{BookGenerator.generate(1), BookGenerator.generate(5)}, QueryType.GET, BookField.AUTHOR_NAME, "Author1"},
                {{BookGenerator.generate(1), BookGenerator.generate(5)}, QueryType.GET, BookField.PUBLISHER_NAME, "Publisher2"}
        });
    }*/

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

    @Test
    public void process2() {
        Book[] expected = new Book[2];
        expected[0] = BookGenerator.generate(2);
        expected[1] = BookGenerator.generate(5);
        assertArrayEquals(expected,
                BookQueryProcessor.process(
                        books, QueryType.GET,
                        BookField.PUBLISHER_NAME, "Publisher2"));
    }
}