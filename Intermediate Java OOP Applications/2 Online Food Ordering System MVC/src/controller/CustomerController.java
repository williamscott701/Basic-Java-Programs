package controller;

import dto.CartDto;
import dto.CustomerDto;
import dto.MenuItemDto;
import dto.OrderHistoryDto;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CustomerController extends Thread {

    static Scanner in = new Scanner(System.in);

    public static CustomerDto login() {

        System.out.println("Enter Email");
        String email = in.next();
        System.out.println("Enter Password");
        String password = in.next();

        return DatabaseController.getCustomer(new CustomerDto(password.hashCode(), email));

    }

    public static CustomerDto signup() {
        System.out.println("Enter Name:");
        String name = in.next();
        System.out.println("Enter Email");
        String email = in.next();
        System.out.println("Enter Mobile");
        BigInteger mobile = in.nextBigInteger();
        System.out.println("Enter Password");
        String password = in.next();

        return DatabaseController.addCustomer(new CustomerDto(email.hashCode(), name, password.hashCode(), email, mobile));

    }

    public static void getAllItems() {

        MenuItemDto[] m = DatabaseController.getMenu();
        System.out.println("\nItemID\t\tName\t\tPrice\t\tDescription\tIs Veg\t\tRestaurent Name");
        try {
            for (int i = 0; i < m.length - 1; i++) {
                System.out.println(m[i].getItemId() + "\t\t" + m[i].getItemName() + "\t\t" + m[i].getPrice() + "\t\t" + m[i].getDescription() + "\t\t" + m[i].isVeg() + "\t\t" + m[i].getRestaurentName());
            }
        } catch (Exception e) {

        }
    }

    public static void placeOrder(String email, int customerId) throws InterruptedException {

        CartDto c = DatabaseController.getCart(email);
        int total = 0;
        int restaurentId = 0;
        for (int i = 0; i < c.getItem().size(); i++) {
            MenuItemDto m = DatabaseController.getMenuItem((int) c.getItem().get(i));
            if (!m.getItemName().equals("failed")) {
                total = m.getPrice();
                restaurentId = m.getRestaurentId();
            }
        }
        int min = DatabaseController.getRestaurentB(restaurentId).getMinimumOrder();
        int delivery = DatabaseController.getRestaurentB(restaurentId).getDeliveryFee();

        total += delivery;
        if (total < min) {
            System.out.println("Minimum order of this restaurent is " + min);
            System.out.println("Your total in cart is: " + total);
        } else {

            OrderHistoryDto o = new OrderHistoryDto(new Date(), total, customerId, restaurentId, c);
            CartDto cart = o.getCart();
            System.out.println("\n\nOrdered On: " + o.getTimestamp());
            System.out.println("Order ID: " + java.lang.Math.abs(o.getTimestamp().hashCode()));
            System.out.println("Total: " + o.getTotal());
            System.out.println("\nItemID\t\tItem\t\tPrice\t\tDescription\tIs Veg\t\tRestaurent");
            for (int i = 0; i < cart.getItem().size(); i++) {
                MenuItemDto m = DatabaseController.getMenuItem((int) cart.getItem().get(i));
                if (!m.getItemName().equals("failed")) {
                    System.out.println(m.getItemId() + "\t\t" + m.getItemName() + "\t\t" + m.getPrice() + "\t\t" + m.getDescription() + "\t\t" + m.isVeg() + "\t\t" + m.getRestaurentName());
                }
            }
            DatabaseController.addOrderHistory(o);

            System.out.println("Order Placed Successfully");
            System.out.println("\n**Update: Waiting for Restaurnet to confirm your order");

            Thread.sleep(1000);
            System.out.println("**Update: Order Confirmed Successfully");

            Thread.sleep(2000);
            System.out.println("**Update: Agent arrived at restaurent and waiting for pickup");

            Thread.sleep(1000);
            System.out.println("**Update: Agent Picked up your Order and will arrive in 15 minutes");

            Thread.sleep(3000);
            System.out.println("**Update: Arriving in 2 minutes");
            Thread.sleep(1000);
            System.out.println("**Update: Order Delivered");
            System.out.println("\nThank you for placing the order");
//            DatabaseController.removeCart(email);
        }
    }

    public static void printOrderHistory(String email, int customerId) {

        ArrayList a = DatabaseController.getOrderHistoryCustomer(customerId);

        if (a.size() == 0) {
            System.out.println("\n\nYou never ordered anything before!\nYou got to be kidding me");
        }

        for (int j = 0; j < a.size(); j++) {
            OrderHistoryDto o = (OrderHistoryDto) a.get(j);
            CartDto cart = o.getCart();
            System.out.println("\n\nOrdered On: " + o.getTimestamp());
            System.out.println("\n\nOrdere ID: " + java.lang.Math.abs(o.getTimestamp().hashCode()));
            System.out.println("Total: " + o.getTotal());
            System.out.println("\nItemID\t\tItem\t\tPrice\t\tDescription\tIs Veg\t\tRestaurent");
            for (int i = 0; i < cart.getItem().size(); i++) {
                MenuItemDto m = DatabaseController.getMenuItem((int) cart.getItem().get(i));
                if (!m.getItemName().equals("failed")) {
                    System.out.println(m.getItemId() + "\t\t" + m.getItemName() + "\t\t" + m.getPrice() + "\t\t" + m.getDescription() + "\t\t" + m.isVeg() + "\t\t" + m.getRestaurentName());
                }
            }
        }

    }
}
