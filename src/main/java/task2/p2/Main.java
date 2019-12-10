package task2.p2;

import task2.p2.controller.BooksController;
import task2.p2.model.repository.BooksRepository;
import task2.p2.model.service.BooksService;
import task2.p2.model.utils.BooksRepositoryGenerator;
import task2.p2.view.BooksView;

public class Main {
    public static void main(String[] args) {
        BooksService booksService = new BooksService();
        BooksView booksView = new BooksView();
        BooksController booksController = new BooksController(booksService, booksView);
        booksController.demo();
    }
}
