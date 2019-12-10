package task2.p2;

public class Book {
    private String bookName;
    private String authorName;
    private String publisherName;
    private int yearOfPublishing;
    private int numberOfPages;
    private int price;

    Book(String bookName, String authorName, String publisherName, int yearOfPublishing, int numberOfPages, int price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("\"%s\", written by %s. Published by %s in %d.\nConsist of %d pages, with total price of $%d",
                bookName, authorName, publisherName, yearOfPublishing, numberOfPages, price);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
