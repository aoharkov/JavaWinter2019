package task2.p2.model.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import task2.p2.model.domain.Book;
import task2.p2.model.domain.BookField;
import task2.p2.model.domain.QueryType;
import task2.p2.model.utils.BookArrayGenerator;
import task2.p2.model.utils.BookGenerator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BookQueryProcessorTest {
    private Book[] books = BookArrayGenerator.generate(6);
    @Parameterized.Parameter
    public Book[] expected;
    @Parameterized.Parameter(1)
    public QueryType queryType;
    @Parameterized.Parameter(2)
    public BookField bookField;
    @Parameterized.Parameter(3)
    public String[] args;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new Book[]{BookGenerator.generate(1), BookGenerator.generate(5)},
                        QueryType.GET, BookField.AUTHOR_NAME, new String[]{"Author1"}},
                {new Book[]{BookGenerator.generate(2), BookGenerator.generate(5)},
                        QueryType.GET, BookField.PUBLISHER_NAME, new String[]{"Publisher2"}}
        });
    }

    @Test
    public void process() {
        assertArrayEquals(expected,
                BookQueryProcessor.process(
                        books, queryType,
                        bookField, args));
    }
}