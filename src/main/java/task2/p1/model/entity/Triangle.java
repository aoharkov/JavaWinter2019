package task2.p1.model.entity;

public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(String color, double a, double b, double c) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Triangle parseShape(String data) {
        //Example of data == "Triangle:red, 10, 10, 10"
        String[] tokens = data.split("[:,]");
        return new Triangle(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]));
    }

    @Override
    public double calcArea() {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return super.toString() +
                ", a = " + a + ", b = " + b + ", c = " + c;
    }
}
