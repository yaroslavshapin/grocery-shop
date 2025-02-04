package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroceryShopServiceTest {
    private GroceryShopService groceryShopService;

    @BeforeEach
    void setUp() {
        groceryShopService = new GroceryShopService();
    }

    @Test
    void testCheckAvailability() {
        assertTrue(groceryShopService.checkAvailability("Apple", 5));
        assertFalse(groceryShopService.checkAvailability("Bread", 20));
    }

    @Test
    void testAddToCart() {
        String result = groceryShopService.addToCart("Apple", 5);
        assertEquals("5 units of Apple have been added to the cart.", result);

        String resultNotAvailable = groceryShopService.addToCart("Bread", 20);
        assertEquals("Unfortunately, there is insufficient stock of Bread.", resultNotAvailable);
    }

    @Test
    void testPlaceOrder() {
        groceryShopService.addToCart("Apple", 5);
        String result = groceryShopService.placeOrder();
        assertEquals("Your order has been successfully placed!", result);

        String resultEmptyCart = groceryShopService.placeOrder();
        assertEquals("Your cart is empty. Add groceries to place an order.", resultEmptyCart);
    }
}