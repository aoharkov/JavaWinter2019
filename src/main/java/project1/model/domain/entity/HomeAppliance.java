package project1.model.domain.entity;

import java.util.Objects;

/**
 * Home appliances, also known as domestic appliances,
 * are electrical machines that help in household functions such as
 * cooking, cleaning and food preservation.
 * <p>
 * They may be divided into the three classifications:
 * small appliances, major appliances, and consumer electronics.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Home_appliance">Corresponding article in the English wikipedia</a>
 */
public class HomeAppliance implements Powerable {
    /**
     * Full name of device
     */
    private String name;
    /**
     * Typical consumption of power per hour, in watts.
     */
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
        return String.format("%s, %d W", name, power);
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
