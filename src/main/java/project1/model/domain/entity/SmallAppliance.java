package project1.model.domain.entity;

public class SmallAppliance extends HomeAppliance {
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
