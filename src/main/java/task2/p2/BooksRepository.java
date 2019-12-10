package task2.p2;

public class BooksRepository {
    private Book[] books;

    public BooksRepository(Book[] books) {
        this.books = books;
    }

    public BooksRepository() {

    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
