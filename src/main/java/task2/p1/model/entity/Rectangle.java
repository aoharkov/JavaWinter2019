package task2.p1.model.entity;

public class Rectangle extends Shape {
    private double w;
    private double h;

    public Rectangle(String color, double w, double h) {
        super(color);
        this.w = w;
        this.h = h;
    }

    public static Rectangle parseShape(String data) {
        //Example of data == "Rectangle:red,10,10"
        String[] tokens = data.split("[:,]");
        return new Rectangle(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
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
