package task3.p1.model.domain;

public class Doll extends Toy {
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
