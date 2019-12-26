package project1.model.domain.entity;

public class SmallAppliance extends HomeAppliance {
    private boolean wireless;

    public SmallAppliance(String name, int power, boolean wireless) {
        super(name, power);
        this.wireless = wireless;
    }

    public boolean isWireless() {
        return wireless;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }
}
