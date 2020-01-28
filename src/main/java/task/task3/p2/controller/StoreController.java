package task.task3.p2.controller;

import task.task3.p2.model.Product;
import task.task3.p2.model.ProductPack;
import task.task3.p2.model.SortTypes;
import task.task3.p2.model.Store;
import task.task3.p2.view.StoreInput;
import task.task3.p2.view.StoreView;

public class StoreController implements Runnable {
    private static final String FRUITS = "Fruits";
    private static final String VEGETABLES = "Vegetables";
    private StoreInput input;
    private StoreView view;
    private Store store;

    public StoreController() {
        this.input = new StoreInput();
        this.view = new StoreView();
    }

    @Override
    public void run() {
        demo1();
    }

    private void demo1() {
        openFoodStore();
        sellFromVegetableSection();
        moveFromVegetableSection();
        sortDemo();
        mergeFoodSections();
    }

    private void openFoodStore() {
        view.viewData(StoreView.OPEN_FOOD_STORE);
        store = new Store("Food Shop");
        store.openSection(FRUITS, 1);
        ProductPack[] fruits = {
                new ProductPack(new Product("Banana", 25), 8),
                new ProductPack(new Product("Apple", 15), 20),
                new ProductPack(new Product("Orange", 35), 10)
        };
        store.getSectionByName(FRUITS).deliver(fruits);

        store.openSection(VEGETABLES, 2);
        ProductPack[] vegetables = {
                new ProductPack(new Product("Potato", 12), 60),
                new ProductPack(new Product("Carrot", 10), 20),
                new ProductPack(new Product("Tomato", 35), 16)
        };
        store.getSectionByName(VEGETABLES).deliver(vegetables);

        view.viewData(store.toString());
        view.viewData(StoreView.DELIMITER);
    }

    private void sellFromVegetableSection() {
        view.viewData(StoreView.SELL_FROM_VEGETABLE_SECTION);
        Store.Section section = store.getSectionByName(VEGETABLES);
        ProductPack[] cheque = {
                new ProductPack(new Product("Potato", 12), 10),
                new ProductPack(new Product("Tomato", 35), 6)};
        section.take(cheque);
        view.viewData(store.toString());
        view.viewData(StoreView.DELIMITER);
    }

    private void moveFromVegetableSection() {
        view.viewData(StoreView.MOVE_FROM_VEGETABLE_SECTION);
        ProductPack[] freight = {new ProductPack(new Product("Tomato", 35), 10)};
        store.moveFromToSection(VEGETABLES, FRUITS, freight);
        view.viewData(store.toString());
        view.viewData(StoreView.DELIMITER);
    }

    private void mergeFoodSections() {
        view.viewData(StoreView.MERGE_FOOD_SECTIONS);
        store.merge(FRUITS, VEGETABLES);
        view.viewData(store.toString());
        view.viewData(StoreView.DELIMITER);
    }

    private void sortDemo() {
        sortStoreBy(SortTypes.QUANTITY);
        sortStoreBy(SortTypes.NAME);
        sortStoreBy(SortTypes.PRICE);
    }

    private void sortStoreBy(SortTypes type) {
        view.viewData(String.format(StoreView.SORT_WITHIN_SECTION_DEMO_BY, type));
        store.sortByQuery(type);
        view.viewData(store.toString());
        view.viewData(StoreView.DELIMITER);
    }
}
