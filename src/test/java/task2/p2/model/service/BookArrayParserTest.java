package task2.p2.model.service;

import org.junit.Test;
import task2.p2.model.domain.Book;

import static org.junit.Assert.assertEquals;

public class BookArrayParserTest {

    @Test
    public void testParse() {
        String expected = "Repository consist of 0 books.\n";
        assertEquals(expected, BookArrayParser.parse(new Book[0]));
    }
}