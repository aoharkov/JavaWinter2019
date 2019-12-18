package task3.p1.controller;

import task3.p1.model.service.ToyService;
import task3.p1.view.ToyView;

public class ToyController implements Runnable{
    private ToyService service = new ToyService();
    private ToyView view = new ToyView();

    @Override
    public void run() {

    }

    private void sortByPrice(){
        view.viewData("Sorting by price");
        view.viewData(service.sortByPrice());
    }

    private void calculateTotalPrice(){
        view.viewData("Calculating total price");
        view.viewData(service.calculateTotalPrice());
    }
}
