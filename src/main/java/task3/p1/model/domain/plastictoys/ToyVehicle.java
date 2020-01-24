package task3.p1.model.domain.plastictoys;

public abstract class ToyVehicle extends PlasticToy {
    private boolean remote = Math.random() > 0.8;

    @Override
    public String toString() {
        return super.toString() +
                ", remote = " + remote;
    }
}
