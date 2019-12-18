package task3.p1.controller;

import task3.p1.model.domain.ToyType;
import task3.p1.model.service.ToyService;
import task3.p1.view.ToyView;

public class ToyController implements Runnable{
    private ToyService service = new ToyService();
    private ToyView view = new ToyView();

    @Override
    public void run() {
        generateArrayOfType();
        sortByPrice();
        //calculateTotalPrice();
    }
    private void generateArrayOfType() {
        view.viewData("Generating new dataset");
        service.generateArrayOfType(6, ToyType.TOYCAR);
        view.viewData(service.showArrayOfToys());
    }

    private void sortByPrice(){
        view.viewData("Sorting by price");
        view.viewData(service.sortByPrice());
    }

    private void calculateTotalPrice(){
        view.viewData("Calculating total price");
        view.viewData(Integer.toString(service.calculateTotalPrice()));
    }
}
