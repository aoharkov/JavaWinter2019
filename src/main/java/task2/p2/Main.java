package task2.p2;

public class Main {
    public static void main(String[] args) {
        BooksRepository booksRepository = BooksRepositoryGenerator.generate(6);
        System.out.println(booksRepository);
    }
}
