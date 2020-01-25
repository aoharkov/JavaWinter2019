package task3.p2.controller;

import task3.p2.model.Product;
import task3.p2.model.ProductPack;
import task3.p2.model.SortTypes;
import task3.p2.model.Store;
import task3.p2.view.StoreInput;
import task3.p2.view.StoreView;

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
        view.viewData("openFoodStore:");
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
        view.viewData("sellFromVegetableSection:");
        Store.Section section = store.getSectionByName(VEGETABLES);
        ProductPack[] cheque = {
                new ProductPack(new Product("Potato", 12), 10),
                new ProductPack(new Product("Tomato", 35), 6)};
        section.take(cheque);
        view.viewData(store.toString());
        view.viewData(StoreView.DELIMITER);
    }

    private void moveFromVegetableSection() {
        view.viewData("moveFromVegetableSection:");
        ProductPack[] freight = {new ProductPack(new Product("Tomato", 35), 10)};
        store.moveFromToSection(VEGETABLES, FRUITS, freight);
        view.viewData(store.toString());
        view.viewData(StoreView.DELIMITER);
    }

    private void mergeFoodSections() {
        view.viewData("mergeFoodSections:");
        Store.Section largerSection = store.getSectionByName(FRUITS);
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
        view.viewData(String.format("sortWithinSectionDemo by %s:", type));
        store.sortByQuery(type);
        view.viewData(store.toString());
        view.viewData(StoreView.DELIMITER);
    }
}
