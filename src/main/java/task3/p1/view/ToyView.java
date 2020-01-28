package task3.p1.view;

public class ToyView {
    public static final String SHOWING_NEW_DATASET = "Showing new dataset";
    public static final String SORTING_BY_PRICE = "Sorting by price";
    public static final String CALCULATING_TOTAL_PRICE = "Calculating total price";
    public static final String FILTERING_WITHIN_RANGE_BY_PRICES = "Filtering within range by prices";
    public static final String PLEASE_ENTER_THE_RANGE_MIN_MAX = "Please enter the range: min max";
    public static final String DELIMITER = "-----------------";
    public static final String EXAMPLE_1 = "Example 1: with PlasticToy[] = {6 elements of TOYCAR}";
    public static final String EXAMPLE_2 = "Example 2: with PlasticToy[] = {6 elements of PUZZLE}";
    public static final String EXAMPLE_3 = "Example 3: with PlasticToy[] = {DOLL, PUZZLE, TOYBOAT, TOYCAR}";
    public static final String EXAMPLE_4 = "Example 4: with TabletopGame[] = {12 elements of BOARDGAME}";
    public static final String EXAMPLE_5 = "Example 5: with TabletopGame[] = {BOARDGAME, CARDGAME, BOARDGAME, CARDGAME}";
    public static final String EXAMPLE_6 = "Example 6: with TabletopGame[] = {12 elements of CARDGAME}";

    public void viewData(String message) {
        System.out.println(message);
    }
}
