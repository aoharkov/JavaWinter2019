package task2.p2;

class BookGenerator {
    static Book generate(int id) {
        String bookName = "Book" + id;
        String authorName = "Author" + ((id - 1) % 4 + 1);
        String publisherName = "Publisher" + ((id - 1) % 3 + 1);
        int yearOfPublishing = 2000 - id;
        int numberOfPages = 100 + id;
        int price = 30 + id;
        return new Book(bookName, authorName, publisherName, yearOfPublishing, numberOfPages, price);
    }
}
