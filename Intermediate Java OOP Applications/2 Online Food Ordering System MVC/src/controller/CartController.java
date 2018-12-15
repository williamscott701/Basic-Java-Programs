package controller;

import dto.CartDto;
import dto.MenuItemDto;
import java.util.LinkedList;
import java.util.Scanner;

public class CartController {

    static Scanner in = new Scanner(System.in);

    public static void addToCart(String email) {
        System.out.print("Enter ItemID: ");
        int itemId = in.nextInt();

        if (DatabaseController.getMenuItem(itemId).getItemName().equals("failed")) {
            System.out.println("\nInvalid ItemId");
        } else {
            CartDto c = getCart(email);
            if (c.getCustomerEmail().equals("failed")) {
                LinkedList l = new LinkedList();
                l.add(itemId);
                CartDto cart = new CartDto(l, email);
                DatabaseController.addCart(cart);
            } else {

                MenuItemDto m = DatabaseController.getMenuItem((int) c.getItem().get(0));
                if (m.getRestaurentName().equals(DatabaseController.getMenuItem(itemId).getRestaurentName())) {
                    c.getItem().add(itemId);
                } else {
                    System.out.println("\n\nReplacing the Cart with current Restaurent");
                    LinkedList l = new LinkedList();
                    l.add(itemId);
                    c.setItem(l);
                }
            }
            System.out.println("\nAdded to Cart");
        }
    }

    public static CartDto getCart(String email) {
        return DatabaseController.getCart(email);
    }

    public static void printCart(String email) {
        CartDto cart = DatabaseController.getCart(email);
        if (getCart(email).getCustomerEmail().equals("failed")) {
            System.out.println("\n\nNothing in Cart :(");
        } else {
            System.out.println("-----Cart-----");
            System.out.println("ItemID\t\tItem\t\tPrice\t\tDescription\tIs Veg\t\tRestaurent");
            int total = 0;
            int restId = 0;
            for (int i = 0; i < cart.getItem().size(); i++) {
                MenuItemDto m = DatabaseController.getMenuItem((int) cart.getItem().get(i));
                if (!m.getItemName().equals("failed")) {
                    total += m.getPrice();
                    System.out.println(m.getItemId() + "\t\t" + m.getItemName() + "\t\t" + m.getPrice() + "\t\t" + m.getDescription() + "\t\t" + m.isVeg() + "\t\t" + m.getRestaurentName());

                    restId = m.getRestaurentId();
                }
            }
            int delivery = DatabaseController.getRestaurentDeliveryFee(restId);
            System.out.println("Sub Total: " + total);
            System.out.println("Delivery: " + delivery);
            System.out.println("Total: " + (total + delivery));
        }
    }

    public static void removeFromCart(String email) {
        System.out.print("Enter ItemID: ");
        int itemId = in.nextInt();

        if (DatabaseController.getMenuItem(itemId).getItemName().equals("failed")) {
            System.out.println("\nInvalid ItemId");
        } else {
            CartDto c = getCart(email);
            LinkedList l = c.getItem();

            if (l.contains(itemId)) {
                if (l.size() == 1) {
                    c.setItem(new LinkedList());
                    System.out.println("Removed Successfully");
                } else {
                    l.remove(itemId);
                    System.out.println("Removed Successfully");
                    c.setItem(l);
                }
            } else {
                System.out.println("Item Not in Cart");
            }
        }
    }
}
