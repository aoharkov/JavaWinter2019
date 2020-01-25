package project1.model.domain.entity;

/**
 * Major appliances differ from small appliances because they are bigger and not portable.
 * <p>
 * Examples include refrigerator, kitchen stove, dishwasher, and washing machine.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Major_appliance">Corresponding article in the English wikipedia</a>
 */
public class MajorAppliance extends HomeAppliance {
    /**
     * Height, in millimeters.
     */
    private int height;
    /**
     * Width, in millimeters.
     */
    private int width;
    /**
     * Length, in millimeters.
     */
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
