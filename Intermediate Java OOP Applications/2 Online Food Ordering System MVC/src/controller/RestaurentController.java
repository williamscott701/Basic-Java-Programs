package controller;

import dto.CartDto;
import dto.MenuItemDto;
import dto.OrderHistoryDto;
import dto.RestaurentDto;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RestaurentController {

    static Scanner in = new Scanner(System.in);
    static Random random = new Random();

    public static RestaurentDto login() {

        System.out.println("Enter Email");
        String email = in.next();
        System.out.println("Enter Password");
        String password = in.next();

        return DatabaseController.getRestaurent(new RestaurentDto(password.hashCode(), email));

    }

    public static void addItems(String email, String restName) {
        System.out.println(email);
        System.out.println("Enter Name");
        String name = in.next();
        System.out.println("Enter Description");
        String desc = in.next();
        System.out.println("Enter Price");
        int price = in.nextInt();
        System.out.println("is Veg");
        String isVeg = in.next();
        System.out.println("G: " + email.hashCode());
        MenuItemDto m = new MenuItemDto(name.hashCode() + random.nextInt(200), email.hashCode(), name, price, desc, isVeg, restName);
        DatabaseController.addMenuItem(m);
    }

    public static void checkItems(String restName) {

        MenuItemDto[] m = DatabaseController.getMenu();
        System.out.println("ItemId\t\tName\t\tPrice\t\tDescription\tIs Veg\t\tRestaurent Name");
        try {
            for (int i = 0; i < m.length - 1; i++) {
                if (m[i].getRestaurentId() == restName.hashCode()) {
                    System.out.println(m[i].getItemId() + "\t\t" + m[i].getItemName() + "\t\t" + m[i].getPrice() + "\t\t" + m[i].getDescription() + "\t\t" + m[i].isVeg() + "\t\t" + m[i].getRestaurentName());
                }
            }
        } catch (Exception e) {

        }
    }

    public static void printOrderHistory(String email) {
        ArrayList a = DatabaseController.getOrderHistoryRestaurent(email.hashCode());

        if (a.isEmpty()) {
            System.out.println("\n\nTheres Nothing Here!");
        }

        for (int j = 0; j < a.size(); j++) {
            OrderHistoryDto o = (OrderHistoryDto) a.get(j);
            CartDto cart = o.getCart();
            System.out.println("\n\nOrdered On: " + o.getTimestamp());
            System.out.println("\n\nOrdere ID: " + java.lang.Math.abs(o.getTimestamp().hashCode()));
            System.out.println("Total: " + o.getTotal());
            System.out.println("\nItemID\t\tItem\t\tPrice\t\tDescription\tIs Veg");
            for (int i = 0; i < cart.getItem().size(); i++) {
                MenuItemDto m = DatabaseController.getMenuItem((int) cart.getItem().get(i));
                if (!m.getItemName().equals("failed")) {
                    System.out.println(m.getItemId() + "\t\t" + m.getItemName() + "\t\t" + m.getPrice() + "\t\t" + m.getDescription() + "\t\t" + m.isVeg());
                }
            }
        }
    }
}
