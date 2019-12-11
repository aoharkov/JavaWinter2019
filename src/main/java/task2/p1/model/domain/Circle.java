package task2.p1.model.domain;

public class Circle extends Shape {
    private double r;

    public Circle(String color, double r) {
        super(color);
        this.r = r;
    }

    @Override
    public double calcArea() {
        return Math.PI * r * r;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", r = " + r;
    }
}
