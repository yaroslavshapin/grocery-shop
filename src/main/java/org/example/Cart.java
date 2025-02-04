package org.example;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String, Integer> cartItems = new HashMap<>();

    public void addToCart(String groceryProduct, int quantity) {
        cartItems.put(groceryProduct, cartItems.getOrDefault(groceryProduct, 0) + quantity);
    }

    public void removeFromCart(String groceryProduct) {
        cartItems.remove(groceryProduct);
    }

    public void clearCart() {
        cartItems.clear();
    }

    public Map<String, Integer> getCartItems() {
        return cartItems;
    }
}
