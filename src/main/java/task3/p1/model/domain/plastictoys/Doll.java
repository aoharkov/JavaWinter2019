package task3.p1.model.domain.plastictoys;

public class Doll extends PlasticToy {
    private static int dollCounter = 0;

    @Override
    protected void incToyCounter() {
        dollCounter++;
    }

    @Override
    protected int getToyCounter() {
        return dollCounter;
    }

}
