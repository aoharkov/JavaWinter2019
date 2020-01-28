package task.task3.p1.model.domain.plastictoys;

import task.task3.p1.model.domain.ToyItem;

public abstract class PlasticToy implements ToyItem {
    private static int counter = 0;
    private static int toyCounter = 0;

    private int id;
    private String name;
    private int price;

    PlasticToy() {
        counter++;
        incToyCounter();
        this.id = counter;
        this.name = getClass().getSimpleName() + getToyCounter();
        this.price = (int) (Math.random() * 90) + 10;
    }

    protected void incToyCounter() {
        toyCounter++;
    }

    protected int getToyCounter() {
        return toyCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": id = " + id +
                ", name = " + name +
                ", price = " + price;
    }
}
