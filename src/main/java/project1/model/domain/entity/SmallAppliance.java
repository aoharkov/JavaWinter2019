package project1.model.domain.entity;

/**
 * A small appliance are portable or semi-portable machines,
 * generally used on table-tops, counter-tops, or other platforms, to accomplish a household task.
 * <p>
 * Examples include microwave ovens, toasters, humidifiers, and coffeemakers.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Small_appliance">Corresponding article in the English wikipedia</a>
 */
public class SmallAppliance extends HomeAppliance {
    /**
     * Weight, in grams.
     */
    private int weight;

    public SmallAppliance(String name, int power, int weight) {
        super(name, power);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
