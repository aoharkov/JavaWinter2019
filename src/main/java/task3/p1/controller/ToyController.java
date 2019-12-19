package task3.p1.controller;

import task3.p1.model.domain.PlasticToyType;
import task3.p1.model.domain.ToyItem;
import task3.p1.model.domain.plastictoys.*;
import task3.p1.model.service.Playroom;
import task3.p1.model.service.ToysGenerator;
import task3.p1.view.ToyView;

public class ToyController implements Runnable{
    private Playroom<?> playroom;
    private ToyView view = new ToyView();

    @Override
    public void run() {
        demo1();
        demo2();
        demo3();
    }

    private void runStandardOperations() {
        showArray();
        sortByPrice();
        calculateTotalPrice();
    }

    private void demo1() {
        view.viewData("Example 1: with PlasticToy[] = {6 elements of TOYCAR}");
        PlasticToy[] array = ToysGenerator.generateArrayOfPlasticToys(6, PlasticToyType.TOYCAR);
        playroom = new Playroom<>(array);
        runStandardOperations();
    }

    private void demo2() {
        view.viewData("Example 2: with PlasticToy[] = {6 elements of PUZZLE}");
        PlasticToy[] array = ToysGenerator.generateArrayOfPlasticToys(6, PlasticToyType.PUZZLE);
        playroom = new Playroom<>(array);
        runStandardOperations();
    }

    private void demo3() {
        view.viewData("Example 3: with PlasticToy[] = {DOLL, PUZZLE, TOYBOAT, TOYCAR}");
        PlasticToy[] array = {new Doll(), new Puzzle(), new ToyBoat(), new ToyCar()};
        playroom = new Playroom<>(array);
        runStandardOperations();
    }

    private void showArray() {
        view.viewData("Showing new dataset");
        view.viewData(playroom.parse());
    }

    private void sortByPrice(){
        view.viewData("Sorting by price");
        playroom.sortByPrice();
        view.viewData(playroom.parse());
    }

    private void calculateTotalPrice(){
        view.viewData("Calculating total price");
        view.viewData(Integer.toString(playroom.calculateTotalPrice()));
    }
}
