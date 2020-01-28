package task2.p2.view;

public class BookView {
    public static final String BOOKS_SORTED_BY_PUBLISHER = "Books sorted by publisher";
    public static final String ENTER_NAME_OF_AUTHOR_FOR_SEARCH = "Enter name of author for search -> ";
    public static final String BOOKS_OF = "Books of %s\n%s";
    public static final String ENTER_NAME_OF_PUBLISHER_FOR_SEARCH = "Enter name of publisher for search -> ";
    public static final String ENTER_YEAR_AFTER_TO_FILTER = "Enter year after to filter-> ";
    public static final String BOOKS_AFTER = "Books after %s\n%s";

    public void viewData(String message) {
        System.out.println(message);
    }
}
