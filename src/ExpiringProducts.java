public class ExpiringProducts extends ShippableProduct {
    public ExpiringProducts(String name, double price, int qty, double weight) {
        super(name, price, qty, weight);
    }

    @Override public boolean isExpired() { return false; }
}
