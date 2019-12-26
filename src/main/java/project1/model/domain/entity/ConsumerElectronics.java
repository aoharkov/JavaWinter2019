package project1.model.domain.entity;

public class ConsumerElectronics extends HomeAppliance {
    private boolean internetConnection;

    public ConsumerElectronics(String name, int power, boolean internetConnection) {
        super(name, power);
        this.internetConnection = internetConnection;
    }

    public boolean isInternetConnection() {
        return internetConnection;
    }

    public void setInternetConnection(boolean internetConnection) {
        this.internetConnection = internetConnection;
    }
}
