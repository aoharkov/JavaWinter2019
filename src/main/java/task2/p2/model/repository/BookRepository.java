package task2.p2.model.repository;

import task2.p2.model.domain.Book;

import java.util.Arrays;
import java.util.Comparator;

public class BookRepository {
    private Book[] books;

    public BookRepository(Book[] books) {
        this.books = books;
    }

    public void sortByPublisher() {
        Arrays.sort(books, new Comparator<Book>(){
                    @Override
                    public int compare(Book o1, Book o2) {
                        return o1.getPublisherName().compareTo(o2.getPublisherName());
                    }
                }
            );
    }

    public Book[] showBooksOfAuthor(String authorName) {
        return checkByQueryValueOf("authorName", authorName);
    }

    public Book[] showBooksOfPublisher(String publisherName) {
        return checkByQueryValueOf("publisherName", publisherName);
    }

    public Book[] showBooksOfYearAfter(int year) {
        return checkByQueryValueOf("yearAfter", String.valueOf(year));
    }

    private Book[] checkByQueryValueOf(String nameOfQuery, String valueOfField) {
        boolean[] matched = new boolean[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].checkByQueryValueOf(nameOfQuery, valueOfField)) {
                matched[i] = true;
                counter++;
            }
        }
        Book[] sample = new Book[counter];
        counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (matched[i]) {
                sample[counter] = books[i];
                counter++;
            }
        }
        return sample;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Repository consist of %d books.", books.length));
        if (books.length > 0) {
            str.append(" They are:");
        }
        str.append("\n");
        for (Book book :
                books) {
            str.append(book.toString());
            str.append('\n');
        }
        return str.toString();
    }
}
