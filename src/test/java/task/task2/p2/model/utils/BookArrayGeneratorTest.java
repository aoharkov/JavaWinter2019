package task.task2.p2.model.utils;

import org.junit.Test;
import task.task2.p2.model.domain.Book;

import static org.junit.Assert.assertArrayEquals;

public class BookArrayGeneratorTest {

    @Test
    public void generate() {
        Book[] expected = new Book[2];
        expected[0] = BookGenerator.generate(1);
        expected[1] = BookGenerator.generate(2);
        assertArrayEquals(expected, BookArrayGenerator.generate(2));
    }
}