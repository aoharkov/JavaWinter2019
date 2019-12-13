package task2.p2.model.utils;

import task2.p2.model.domain.Book;
import task2.p2.model.repository.BookRepository;

public class BookRepositoryGenerator {
    public static BookRepository generate(int num) {
        Book[] books = new Book[num];
        for (int i = 0; i < num; i++) {
            books[i] = BookGenerator.generate(i + 1);
        }
        return new BookRepository(books);
    }
}
