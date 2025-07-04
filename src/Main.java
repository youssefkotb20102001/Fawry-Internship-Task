public class Main {
    public static void main(String[] args) {
        Product cheese = new ExpiringProducts("Cheese", 100, 5, 200);
        Product biscuits = new ExpiringProducts("Biscuits", 150, 3, 700);
        Product tv = new ShippableProduct("TV", 3000, 4, 5000);
        Product scratch = new Product("Scratch Card", 50, 10);

        Customer customer = new Customer("youssef", 100000);
        Cart cart = new Cart();

        try {
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(tv, 1);
            cart.add(scratch, 1);
            cart.checkout(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
