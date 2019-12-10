package task2.p2.model.service;

import task2.p2.model.repository.BooksRepository;
import task2.p2.model.utils.BooksRepositoryGenerator;

public class BooksService {
    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public BooksService() {
        this.booksRepository = BooksRepositoryGenerator.generate(6);
    }

    public String showBooks() {
        return booksRepository.toString();
    }

}
