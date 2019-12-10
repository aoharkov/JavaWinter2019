package task2.p2.model.utils;

import task2.p2.model.domain.Book;
import task2.p2.model.repository.BooksRepository;

public class BooksRepositoryGenerator {
    public static BooksRepository generate() {
        return generate(12);
    }

    public static BooksRepository generate(int num) {
        Book[] books = new Book[num];
        for (int i = 0; i < num; i++) {
            books[i] = BookGenerator.generate(i + 1);
        }
        return new BooksRepository(books);
    }
}
