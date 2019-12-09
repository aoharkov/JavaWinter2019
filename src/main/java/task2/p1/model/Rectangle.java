package task2.p1.model;

public class Rectangle extends Shape {
    private double w;
    private double h;

    public Rectangle(String color, double w, double h) {
        super(color);
        this.w = w;
        this.h = h;
    }

    public void draw() {
        System.out.printf("%s; area = %.2f\n", this, calcArea());
    }

    @Override
    public double calcArea() {
        return w * h;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", w = " + w + ", h = " + h;
    }
}
