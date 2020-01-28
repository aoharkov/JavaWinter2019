package task.task2.p2.model.domain;

import java.util.Objects;

public class Book {
    private String bookName;
    private String authorName;
    private String publisherName;
    private int yearOfPublishing;
    private int numberOfPages;
    private int price;

    public Book(String bookName, String authorName, String publisherName, int yearOfPublishing, int numberOfPages, int price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }

    public String getStrByQuery(BookField bookField) {
        switch (bookField) {
            case BOOK_NAME:
                return bookName;
            case AUTHOR_NAME:
                return authorName;
            case PUBLISHER_NAME:
                return publisherName;
            case PRICE:
                return Integer.toString(price);
            case NUMBER_OF_PAGES:
                return Integer.toString(numberOfPages);
            case YEAR_OF_PUBLISHING:
                return Integer.toString(yearOfPublishing);
            default:
                System.out.println("Unknown bookField in getStrByQuery");
                return null;
        }
    }

    public int getIntByQuery(BookField bookField) {
        switch (bookField) {
            case YEAR_OF_PUBLISHING:
                return yearOfPublishing;
            case NUMBER_OF_PAGES:
                return numberOfPages;
            case PRICE:
                return price;
            default:
                System.out.println("Unknown bookField in getIntByQuery");
                return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("\"%s\", written by %s. Published by %s in %d.\nConsist of %d pages, with total price of $%d",
                bookName, authorName, publisherName, yearOfPublishing, numberOfPages, price);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return yearOfPublishing == book.yearOfPublishing &&
                numberOfPages == book.numberOfPages &&
                price == book.price &&
                bookName.equals(book.bookName) &&
                Objects.equals(authorName, book.authorName) &&
                Objects.equals(publisherName, book.publisherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, authorName, publisherName, yearOfPublishing, numberOfPages, price);
    }
}
