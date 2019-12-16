package task3.p1.model.domain;

public class ToyVehicle extends Toy {
    private static int toyVehicleCounter = 0;

    @Override
    protected void incToyCounter() {
        toyVehicleCounter++;
    }

    @Override
    protected int getToyCounter() {
        return toyVehicleCounter;
    }

}
