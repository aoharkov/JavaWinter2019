package task3.p1.model.domain.plastictoys;

public class ToyCar extends ToyVehicle {
    private static int toyCarCounter = 0;

    @Override
    protected void incToyCounter() {
        toyCarCounter++;
    }

    @Override
    protected int getToyCounter() {
        return toyCarCounter;
    }
}
