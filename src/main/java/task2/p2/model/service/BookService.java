package task2.p2.model.service;

import task2.p2.model.repository.BookRepository;
import task2.p2.model.utils.BookRepositoryGenerator;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookService() {
        this.bookRepository = BookRepositoryGenerator.generate(12);
    }

    public String showBooks() {
        return bookRepository.toString();
    }

    public String showBooksOfAuthor(String authorName) {
        BookRepository sample = new BookRepository(bookRepository.showBooksOfAuthor(authorName));
        return sample.toString();
    }

    public String showBooksOfPublisher(String publisherName) {
        BookRepository sample = new BookRepository(bookRepository.showBooksOfPublisher(publisherName));
        return sample.toString();
    }

    public String showBooksOfYearAfter(int year) {
        BookRepository sample = new BookRepository(bookRepository.showBooksOfYearAfter(year));
        return sample.toString();
    }

    public String sortByPublisher() {
        bookRepository.sortByPublisher();
        return bookRepository.toString();
    }


}
