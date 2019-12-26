package project1.model.domain.entity;

public class HomeAppliance implements Powerable {
    private String name;
    private int power;

    public HomeAppliance(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "name =  \"" + name + "\", power = " + power;
    }
}
