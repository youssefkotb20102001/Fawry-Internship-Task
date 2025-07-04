public class CartItem {
    Product product;
    int quantity;

    public CartItem(Product product, int qty) {
        this.product = product;
        this.quantity = qty;
    }
    public double totalPrice() {
        return product.getPrice() * quantity;
    }
}
