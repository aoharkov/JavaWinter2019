package task2.p2.model.utils;

import task2.p2.model.domain.Book;

import java.util.Comparator;

public class BookPublisherComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Book book1 = (Book) o1;
        Book book2 = (Book) o2;
        return book1.getPublisherName().compareTo(book2.getPublisherName());
    }
}
