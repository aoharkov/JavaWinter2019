package task3.p1.model.domain.tabletopgames;

import task3.p1.model.domain.ToyItem;

public abstract class TabletopGame implements ToyItem {
    private String name;
    private int price;
    private int numOfPlayers;

    TabletopGame(String name, int price, int numOfPlayers) {
        this.name = name;
        this.price = price;
        this.numOfPlayers = numOfPlayers;
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
                ", name = '" + name +
                ", price = " + price;
    }
}
