package task3.p2.controller;
import task3.p2.model.Store;
import task3.p2.view.StoreInput;
import task3.p2.view.StoreView;

public class StoreController implements Runnable {
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

    private void demo1(){
        store = new Store("Metro");
        store.openSection("Food", 1);

    }
}
