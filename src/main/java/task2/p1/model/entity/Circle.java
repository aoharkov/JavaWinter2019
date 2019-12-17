package task2.p1.model.entity;

public class Circle extends Shape {
    private double r;

    public Circle(String color, double r) {
        super(color);
        this.r = r;
    }

    public static Circle parseShape(String data) {
        //Example of data == "Circle:red, 10"
        String[] tokens = data.split("[:,]");
        return new Circle(tokens[1], Double.parseDouble(tokens[2]));
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
