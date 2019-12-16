package task3.p1.model.domain;

public class Puzzle extends Toy {
    private static int puzzleCounter = 0;

    @Override
    protected void incToyCounter() {
        puzzleCounter++;
    }

    @Override
    protected int getToyCounter() {
        return puzzleCounter;
    }

}
