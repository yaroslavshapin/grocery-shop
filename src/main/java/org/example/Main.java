package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! It is a new project!");
        System.out.println("Welcome to the Internet Grocery Shop!");

        Scanner scanner = new Scanner(System.in);

        GroceryShopService groceryShopService = new GroceryShopService();

        while (true) {
            System.out.println("\nEnter a command: check (check availability), add (add to cart), order (place order), or exit (exit)");

            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "check":
                    System.out.print("Enter the name of the grocery product: ");
                    String groceryProductToCheck = scanner.nextLine().trim();
                    System.out.print("Enter the quantity: ");
                    int quantityToCheck = scanner.nextInt();
                    scanner.nextLine();

                    boolean isAvailable = groceryShopService.checkAvailability(groceryProductToCheck, quantityToCheck);
                    System.out.println(isAvailable ? "The grocery product is available." : "Insufficient stock.");
                    break;

                case "add":
                    System.out.print("Enter the name of the grocery product: ");
                    String groceryProductToAdd = scanner.nextLine().trim();
                    System.out.print("Enter the quantity: ");
                    int quantityToAdd = scanner.nextInt();
                    scanner.nextLine();

                    String addToCartResult = groceryShopService.addToCart(groceryProductToAdd, quantityToAdd);
                    System.out.println(addToCartResult);
                    break;

                case "order":
                    String orderResult = groceryShopService.placeOrder();
                    System.out.println(orderResult);
                    break;

                case "exit":
                    System.out.println("Thank you for using the Internet Grocery Shop!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }
}


