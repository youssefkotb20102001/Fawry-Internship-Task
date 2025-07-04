import java.util.*;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void add(Product p, int qty) throws Exception {
        if (qty > p.getQuantity()) throw new Exception("Insufficient stock: " + p.getName() );
        items.add(new CartItem(p, qty));
    }

    public void checkout(Customer c) throws Exception {
        if (items.isEmpty()) throw new Exception("Cart is empty.");

        double subtotal = 0, shippingFee = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (CartItem item : items) {
            Product p = item.product;
            if (p.isExpired()) throw new Exception("Expired: " + p.getName());
            if (item.quantity > p.getQuantity()) throw new Exception("Out of stock: " + p.getName());

            subtotal += item.totalPrice();
            p.reduce(item.quantity);

            if (p.needsShipping())
                toShip.addAll(Collections.nCopies(item.quantity, (Shippable) p));
        }

        if (!toShip.isEmpty()) {
            ShippingService.ship(toShip);
            shippingFee = 30;
        }

        double total = subtotal + shippingFee;
        if (c.getBalance() < total) throw new Exception("Insufficient balance.");

        c.pay(total);
        printReceipt(subtotal, shippingFee, total, c.getBalance());
    }

    private void printReceipt(double sub, double ship, double total, double remaining) {
        System.out.println("** Checkout receipt **");
        for (CartItem item : items)
            System.out.printf("%dx %-12s %.0f\n", item.quantity, item.product.getName(), item.totalPrice());
        System.out.printf("----------------------\nSubtotal         %.0f\nShipping         %.0f\nAmount           %.0f\nRemaining Balance %.0f\n", sub, ship, total, remaining);
    }
}
