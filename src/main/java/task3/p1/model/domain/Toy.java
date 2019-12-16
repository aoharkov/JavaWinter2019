package task3.p1.model.domain;

public class Toy {
    protected static int counter = 0;
    private static int toyCounter = 0;

    private int id;
    private String name;

    public Toy() {
        counter++;
        incToyCounter();
        this.id = counter;
        this.name = getClass().getSimpleName() + getToyCounter();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
