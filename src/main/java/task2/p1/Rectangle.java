package task2.p1;

public class Rectangle extends Shape{
    private double w;
    private double h;

    Rectangle (String color, double w, double h) {
        super(color);
        this.w = w;
        this.h = h;
    }
    @Override
    public double calcArea() {
        return w * h / 2.0;
    }

    public void draw() {
        System.out.printf("%s; area=%.2f\n", toString(), calcArea());
    }
}
