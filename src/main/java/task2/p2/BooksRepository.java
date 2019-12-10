package task2.p2;

public class BooksRepository {
    private Book[] books;

    BooksRepository(Book[] books) {
        this.books = books;
    }

    public BooksRepository() {

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Repository consist of %d books. They are:\n", books.length));
        for (Book book:
             books) {
            str.append(book.toString());
            str.append('\n');
        }
        return str.toString();
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
