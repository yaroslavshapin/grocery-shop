package org.example;

import java.util.Map;

public class GroceryShopBranch {
    private String name;
    private double xCoordinate;
    private double yCoordinate;
    private Map<String, Integer> inventory;

    public GroceryShopBranch(String name, double xCoordinate, double yCoordinate, Map<String, Integer> inventory) {
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.inventory = inventory;
    }

    public boolean hasGroceryProduct(String groceryProduct, int quantity) {
        return inventory.getOrDefault(groceryProduct, 0) >= quantity;
    }

    public void updateInventory(String groceryProduct, int quantity) {
        inventory.put(groceryProduct, inventory.get(groceryProduct) - quantity);
    }

    public String getName() {
        return name;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
