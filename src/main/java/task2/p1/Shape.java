package task2.p1;

public abstract class Shape implements Drawable{
    private String color;
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Shape(String colorShape) {
        this.color = colorShape;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": colorShape = " + color;
    }

    public abstract double calcArea();
    }
