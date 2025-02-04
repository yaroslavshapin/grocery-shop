package org.example;
import java.util.HashMap;
import java.util.Map;

public class GroceryShopService {

    private Map<String, Integer> inventory;
    private Map<String, Integer> cart;

    public GroceryShopService() {
        inventory = new HashMap<>();
        cart = new HashMap<>();

        inventory.put("Apple", 20);
        inventory.put("Bread", 15);
        inventory.put("Milk", 10);
    }

    public boolean checkAvailability(String groceryProduct, int quantity) {
        return inventory.getOrDefault(groceryProduct, 0) >= quantity;
    }

    public String addToCart(String groceryProduct, int quantity) {
        if (checkAvailability(groceryProduct, quantity)) {
            cart.put(groceryProduct, cart.getOrDefault(groceryProduct, 0) + quantity);
            inventory.put(groceryProduct, inventory.get(groceryProduct) - quantity);
            return quantity + " units of " + groceryProduct + " have been added to the cart.";
        } else {
            return "Unfortunately, there is insufficient stock of " + groceryProduct + ".";
        }
    }

    public String placeOrder() {
        if (cart.isEmpty()) {
            return "Your cart is empty. Add groceries to place an order.";
        } else {
            cart.clear();
            return "Your order has been successfully placed!";
        }
    }
}