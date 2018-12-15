package controller;

import dto.RestaurentDto;
import java.math.BigInteger;
import java.util.Scanner;

public class AdminController {

    static Scanner in = new Scanner(System.in);

    public static boolean login() {
        System.out.println("Enter Password");
        int c = in.nextInt();
        return c == 1234;
    }

    public static void addRestaurent() {

        System.out.println("Enter Name:");
        String name = in.next();
        System.out.println("Enter Email");
        String email = in.next();
        System.out.println("Enter Mobile");
        BigInteger mobile = in.nextBigInteger();
        System.out.println("Enter Address");
        String address = in.next();
        System.out.println("Enter Minimum Order");
        int minimumOrder = in.nextInt();
        System.out.println("Enter Delivery Charges");
        int deliveryCharges = in.nextInt();
        System.out.println("Enter Password");
        String password = in.next();

        DatabaseController.addRestaurent(new RestaurentDto(email.hashCode(), name, address, mobile, email, password.hashCode(), email, minimumOrder, deliveryCharges));

    }

}
