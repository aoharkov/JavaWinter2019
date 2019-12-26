package project1.model.domain.entity;

public class MajorAppliance extends HomeAppliance {
    private int height;
    private int width;
    private int length;

    public MajorAppliance(String name, int power, int height, int width, int length) {
        super(name, power);
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
