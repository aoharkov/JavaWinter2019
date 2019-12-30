package project1.model.domain.entity;

import java.util.Objects;

public class HomeAppliance implements Powerable {
    private String name;
    private int power; //Typical Consumption Per Hour, in watts

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HomeAppliance)) return false;
        HomeAppliance that = (HomeAppliance) o;
        return power == that.power &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power);
    }
}
