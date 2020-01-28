package task.task2.p2.model.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import task.task2.p2.model.domain.Book;
import task.task2.p2.model.domain.BookField;
import task.task2.p2.model.domain.QueryType;
import task.task2.p2.model.utils.BookArrayGenerator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class BookQueryProcessorTest {
    private Book[] books;

    @Parameterized.Parameter
    public Book[] expected;
    @Parameterized.Parameter(1)
    public QueryType queryType;
    @Parameterized.Parameter(2)
    public BookField bookField;
    @Parameterized.Parameter(3)
    public String[] args;

    @Before
    public void setup() {
        books = BookArrayGenerator.generate(6);
    }

    @Parameterized.Parameters(name = "{index}: {1} ({2})")
    public static Collection data() {
        Book[] books = BookArrayGenerator.generate(6);
        return Arrays.asList(new Object[][]{
                {new Book[]{books[0], books[4]},
                        QueryType.GET,
                        BookField.AUTHOR_NAME,
                        new String[]{"Author1"}},
                {new Book[]{books[1], books[4]},
                        QueryType.GET,
                        BookField.PUBLISHER_NAME,
                        new String[]{"Publisher2"}},
                {books, QueryType.SORT_BY, BookField.BOOK_NAME, null},
                {new Book[]{books[5], books[4], books[3],
                        books[2], books[1], books[0]},
                        QueryType.SORT_BY,
                        BookField.YEAR_OF_PUBLISHING,
                        null},
                {new Book[]{books[0], books[3], books[1],
                        books[4], books[2], books[5]},
                        QueryType.SORT_BY,
                        BookField.PUBLISHER_NAME,
                        null},
                {new Book[]{books[0], books[1]},
                        QueryType.FILTER,
                        BookField.YEAR_OF_PUBLISHING,
                        new String[]{"1997", "after"}}
        });
    }

    @Test
    public void testProcess() {
        assertArrayEquals(expected,
                BookQueryProcessor.process(
                        books, queryType,
                        bookField, args));
    }
}