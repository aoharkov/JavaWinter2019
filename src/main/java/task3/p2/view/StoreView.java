package task3.p2.view;

public class StoreView {
    public static final String DELIMITER = "----------------------------";
    public static final String OPEN_FOOD_STORE = "openFoodStore:";
    public static final String SELL_FROM_VEGETABLE_SECTION = "sellFromVegetableSection:";
    public static final String MOVE_FROM_VEGETABLE_SECTION = "moveFromVegetableSection:";
    public static final String MERGE_FOOD_SECTIONS = "mergeFoodSections:";
    public static final String SORT_WITHIN_SECTION_DEMO_BY = "sortWithinSectionDemo by %s:";

    public void viewData(String message) {
        System.out.println(message);
    }
}
