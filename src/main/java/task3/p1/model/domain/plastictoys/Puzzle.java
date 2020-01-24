package task3.p1.model.domain.plastictoys;

public class Puzzle extends PlasticToy {
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
