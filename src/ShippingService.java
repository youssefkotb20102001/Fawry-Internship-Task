import java.util.*;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        Map<String, Integer> counts = new LinkedHashMap<>();
        Map<String, Double> weights = new HashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            counts.put(item.getName(), counts.getOrDefault(item.getName(), 0) + 1);
            weights.put(item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }

        for (String name : counts.keySet())
            System.out.printf("%dx %-12s %.0fg\n", counts.get(name), name, weights.get(name));
        System.out.printf("Total package weight %.1fkg\n\n", totalWeight / 1000);
    }
}
