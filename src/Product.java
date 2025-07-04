public class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name; this.price = price; this.quantity = quantity;
    }

    public boolean isExpired() { return false; }
    public boolean needsShipping() { return false; }
    public void reduce(int qty) { quantity -= qty; }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
