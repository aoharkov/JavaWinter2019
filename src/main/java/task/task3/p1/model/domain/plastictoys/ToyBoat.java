package task.task3.p1.model.domain.plastictoys;

public class ToyBoat extends ToyVehicle {
    private static int toyBoatCounter = 0;

    @Override
    protected void incToyCounter() {
        toyBoatCounter++;
    }

    @Override
    protected int getToyCounter() {
        return toyBoatCounter;
    }
}
