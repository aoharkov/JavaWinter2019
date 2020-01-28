package task.task2.p1.model.entity;

public abstract class Shape implements Drawable {
    private String shapeColor;

    Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    public String draw() {
        return String.format("%s; area = %.2f\n", this, calcArea());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": shapeColor = " + shapeColor;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }
}
