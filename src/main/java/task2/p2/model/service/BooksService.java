package task2.p2.model.service;

import task2.p2.model.domain.Book;
import task2.p2.model.repository.BooksRepository;
import task2.p2.model.utils.BooksRepositoryGenerator;

import java.awt.image.SampleModel;

public class BooksService {
    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public BooksService() {
        this.booksRepository = BooksRepositoryGenerator.generate(12);
    }

    public String showBooks() {
        return booksRepository.toString();
    }

    public String showBooksOfAuthor(String authorName) {
        BooksRepository sample = new BooksRepository(booksRepository.showBooksOfAuthor(authorName));
        return sample.toString();
    }

    public String showBooksOfPublisher(String publisherName) {
        BooksRepository sample = new BooksRepository(booksRepository.showBooksOfPublisher(publisherName));
        return sample.toString();
    }

    public String showBooksOfYearAfter(int year) {
        BooksRepository sample = new BooksRepository(booksRepository.showBooksOfYearAfter(year));
        return sample.toString();
    }


}
