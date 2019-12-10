package task2.p2;

public class BooksRepositoryGenerator {
    static BooksRepository generate() {
        return generate(12);
    }

    static BooksRepository generate(int num) {
        Book[] books = new Book[num];
        for (int i = 0; i < num; i++) {
            books[i] = BookGenerator.generate(i + 1);
        }
        return new BooksRepository(books);
    }
}
