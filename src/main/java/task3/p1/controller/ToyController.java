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

public class ToyController implements Runnable{
    private Playroom<?> playroom;
    private ToyView view = new ToyView();

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
        view.viewData("-----------------");
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

    private void demo4() {
        view.viewData("Example 4: with TabletopGame[] = {12 elements of BOARDGAME}");
        TabletopGame[] array = ToysGenerator.generateArrayOfTabletopGames(12, TabletopGameType.BOARDGAME);
        playroom = new Playroom<>(array);
        runStandardOperations();
    }

    private void demo5() {
        view.viewData("Example 5: with TabletopGame[] = {BOARDGAME, CARDGAME, BOARDGAME, CARDGAME}");
        TabletopGame[] array = {
                new BoardGame("Chess", 30, 2),
                new CardGame("Solitaire", 6, 1),
                new BoardGame("Battleship", 10, 2),
                new CardGame("Poker", 28, 6)};
        playroom = new Playroom<>(array);
        runStandardOperations();
    }

    private void demo6() {
        view.viewData("Example 6: with TabletopGame[] = {12 elements of CARDGAME}");
        TabletopGame[] array = ToysGenerator.generateArrayOfTabletopGames(12, TabletopGameType.CARDGAME);
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

    private void filterWithinRangeByPrices(){
        view.viewData("Filtering within range by prices");
        view.viewData("Please enter the range: min max");
        int min = Integer.parseInt(ToyInputData.next());
        int max = Integer.parseInt(ToyInputData.next());
        ToyItem[] filtered = playroom.filterWithinRangeByPrices(min, max);
        Playroom<?> filteredPlayroom = new Playroom<>(filtered);
        view.viewData(filteredPlayroom.parse());
    }
}
