import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Integer> cartItemsOrdered = new LinkedHashMap<>();
    private Map<String, Integer> cartItems = new HashMap<>();

    public void addProductPrice(String product, double price) {
        productPrices.put(product, price);
    }

    public void addItem(String product) {
        cartItemsOrdered.put(product, cartItemsOrdered.getOrDefault(product, 0) + 1);
        cartItems.put(product, cartItems.getOrDefault(product, 0) + 1);
    }

    public void removeItem(String product) {
        if (cartItemsOrdered.containsKey(product)) {
            cartItemsOrdered.put(product, cartItemsOrdered.get(product) - 1);
            cartItems.put(product, cartItems.get(product) - 1);
            if (cartItemsOrdered.get(product) == 0) {
                cartItemsOrdered.remove(product);
            }
            if (cartItems.get(product) == 0) {
                cartItems.remove(product);
            }
        }
    }

    public void displayCartOrdered() {
        System.out.println("\n--- Shopping Cart (Order of Items Added) ---");
        for (Map.Entry<String, Integer> entry : cartItemsOrdered.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.getOrDefault(product, 0.0);
            System.out.println(product + " (Qty: " + quantity + ") - $" + String.format("%.2f", price));
        }
    }

    public void displayCartSortedByPrice() {
        TreeMap<Double, String> itemsByPrice = new TreeMap<>();
        for (String product : cartItems.keySet()) {
            double price = productPrices.getOrDefault(product, 0.0);
            itemsByPrice.computeIfAbsent(price, k -> "").equals("") ?
                    itemsByPrice.put(price, product + " (Qty: " + cartItems.get(product) + ")") :
                    itemsByPrice.put(price, itemsByPrice.get(price) + ", " + product + " (Qty: " + cartItems.get(product) + ")");
        }
        System.out.println("\n--- Shopping Cart (Sorted by Price) ---");
        itemsByPrice.forEach((price, items) ->
                System.out.println("$" + String.format("%.2f", price) + ": " + items));
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.getOrDefault(product, 0.0);
            total += price * quantity;
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProductPrice("Laptop", 1200.00);
        cart.addProductPrice("Mouse", 25.00);
        cart.addProductPrice("Keyboard", 75.00);
        cart.addProductPrice("Monitor", 300.00);

        cart.addItem("Laptop");
        cart.addItem("Mouse");
        cart.addItem("Keyboard");
        cart.addItem("Laptop");
        cart.addItem("Monitor");
        cart.addItem("Mouse");

        cart.displayCartOrdered();
        cart.displayCartSortedByPrice();

        System.out.println("\nTotal Cost: $" + String.format("%.2f", cart.calculateTotal()));

        cart.removeItem("Mouse");
        System.out.println("\n--- After Removing a Mouse ---");
        cart.displayCartOrdered();
        cart.displayCartSortedByPrice();
        System.out.println("\nTotal Cost: $" + String.format("%.2f", cart.calculateTotal()));
    }
}