package task3.p2.model;

public class ProductPack {
    private Product product;
    private int quantity;

    public ProductPack(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void takeQuantity(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println(String.format("Not enough %s in productPack", this.product.getName()));
        }

    }

    @Override
    public String toString() {
        return quantity + " x " + product.getName();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
