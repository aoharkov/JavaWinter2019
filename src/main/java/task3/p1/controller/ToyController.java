package task3.p1.controller;

import task3.p1.model.domain.PlasticToyType;
import task3.p1.model.domain.TabletopGameType;
import task3.p1.model.domain.ToyItem;
import task3.p1.model.domain.plastictoys.Doll;
import task3.p1.model.domain.plastictoys.PlasticToy;
import task3.p1.model.domain.plastictoys.Puzzle;
import task3.p1.model.domain.plastictoys.ToyBoat;
import task3.p1.model.domain.plastictoys.ToyCar;
import task3.p1.model.domain.tabletopgames.BoardGame;
import task3.p1.model.domain.tabletopgames.CardGame;
import task3.p1.model.domain.tabletopgames.TabletopGame;
import task3.p1.model.service.Playroom;
import task3.p1.model.service.ToysGenerator;
import task3.p1.view.ToyInputData;
import task3.p1.view.ToyView;

public class ToyController implements Runnable {
    private Playroom<?> playroom;
    private ToyView view;

    public ToyController(ToyView view) {
        this.view = view;
    }

    @Override
    public void run() {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        demo6();
    }

    private void runStandardOperations() {
        showArray();
        sortByPrice();
        calculateTotalPrice();
        filterWithinRangeByPrices();
        view.viewData(ToyView.DELIMITER);
    }

    private void demo1() {
        view.viewData(ToyView.EXAMPLE_1);
        PlasticToy[] array = ToysGenerator.generateArrayOfPlasticToys(6, PlasticToyType.TOYCAR);
        playroom = new Playroom<>(array);
        runStandardOperations();
    }

    private void demo2() {
        view.viewData(ToyView.EXAMPLE_2);
        PlasticToy[] array = ToysGenerator.generateArrayOfPlasticToys(6, PlasticToyType.PUZZLE);
        playroom = new Playroom<>(array);
        runStandardOperations();
    }

    private void demo3() {
        view.viewData(ToyView.EXAMPLE_3);
        PlasticToy[] array = {new Doll(), new Puzzle(), new ToyBoat(), new ToyCar()};
        playroom = new Playroom<>(array);
        runStandardOperations();
    }

    private void demo4() {
        view.viewData(ToyView.EXAMPLE_4);
        TabletopGame[] array = ToysGenerator.generateArrayOfTabletopGames(12, TabletopGameType.BOARDGAME);
        playroom = new Playroom<>(array);
        runStandardOperations();
    }

    private void demo5() {
        view.viewData(ToyView.EXAMPLE_5);
        TabletopGame[] array = {
                new BoardGame("Chess", 30, 2),
                new CardGame("Solitaire", 6, 1),
                new BoardGame("Battleship", 10, 2),
                new CardGame("Poker", 28, 6)};
        playroom = new Playroom<>(array);
        runStandardOperations();
    }

    private void demo6() {
        view.viewData(ToyView.EXAMPLE_6);
        TabletopGame[] array = ToysGenerator.generateArrayOfTabletopGames(12, TabletopGameType.CARDGAME);
        playroom = new Playroom<>(array);
        runStandardOperations();
    }

    private void showArray() {
        view.viewData(ToyView.SHOWING_NEW_DATASET);
        view.viewData(playroom.parse());
    }

    private void sortByPrice() {
        view.viewData(ToyView.SORTING_BY_PRICE);
        playroom.sortByPrice();
        view.viewData(playroom.parse());
    }

    private void calculateTotalPrice() {
        view.viewData(ToyView.CALCULATING_TOTAL_PRICE);
        view.viewData(Integer.toString(playroom.calculateTotalPrice()));
    }

    private void filterWithinRangeByPrices() {
        view.viewData(ToyView.FILTERING_WITHIN_RANGE_BY_PRICES);
        view.viewData(ToyView.PLEASE_ENTER_THE_RANGE_MIN_MAX);
        int min = Integer.parseInt(ToyInputData.next());
        int max = Integer.parseInt(ToyInputData.next());
        ToyItem[] filtered = playroom.filterWithinRangeByPrices(min, max);
        Playroom<?> filteredPlayroom = new Playroom<>(filtered);
        view.viewData(filteredPlayroom.parse());
    }
}
