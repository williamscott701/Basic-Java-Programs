
import controller.AdminController;
import controller.CartController;
import controller.CustomerController;
import controller.DatabaseController;
import controller.RestaurentController;
import dto.CustomerDto;
import dto.RestaurentDto;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        DatabaseController.generateData();
        System.out.println("WS OOPD Assignment 2");

        while (true) {
            System.out.println("\n****Main Menu****");
            System.out.println("Enter your choice:");
            System.out.println("1. Customer");
            System.out.println("2. Restaurent");
            System.out.println("3. Admin");

            int choice = in.nextInt();

            switch (choice) {
                case 1:

                    while (true) {
                        System.out.println("\n----Customer----");
                        System.out.println("\nEnter your choice:");
                        System.out.println("1. Login");
                        System.out.println("2. Signup");
                        System.out.println("3. Go Back");

                        int cchoice = in.nextInt();

                        switch (cchoice) {
                            case 1:
                                System.out.println("\n--Login--");
                                CustomerDto c = CustomerController.login();

                                if (c.getName().equals("failed")) {
                                    System.out.println("Login Unsuccessful");
                                    break;
                                }
                                while (true) {
                                    System.out.println("\n\n***Welcome " + c.getName() + "***");
                                    System.out.println("\nEnter your choice:");
                                    System.out.println("1. Check Available Menus");
                                    System.out.println("2. Add to Cart");
                                    System.out.println("3. Remove from Cart");
                                    System.out.println("4. Check Cart");
                                    System.out.println("5. Place Order");
                                    System.out.println("6. Order History");
                                    System.out.println("7. Logout");
                                    int cc = in.nextInt();

                                    switch (cc) {
                                        case 1:
                                            CustomerController.getAllItems();
                                            break;
                                        case 2:
                                            CartController.addToCart(c.getEmail());
                                            break;
                                        case 3:
                                            CartController.removeFromCart(c.getEmail());
                                            break;
                                        case 4:
                                            CartController.printCart(c.getEmail());
                                            break;
                                        case 5:
                                            CustomerController.placeOrder(c.getEmail(), c.getCustomerId());
                                            break;
                                        case 6:
                                            System.out.println("---Order History---");
                                            CustomerController.printOrderHistory(c.getEmail(), c.getCustomerId());
                                            break;
                                        case 7:
                                            System.out.println("Logging out");
                                            break;
                                        default:
                                            System.out.println("Invalid Input!\n");
                                    }

                                    if (cc == 7) {
                                        break;
                                    }

                                }
                                break;
                            case 2:
                                System.out.println("\n--Signup--");
                                CustomerDto d = CustomerController.signup();

                                if (d.getName().equals("failed")) {
                                    System.out.println("Signup Unsuccessful");
                                    break;
                                } else {
                                    System.out.println("Signup Successful!, Welcome aboard " + d.getName());
                                }

                                break;
                            case 3:
                                System.out.println("Going Back");
                                break;
                            default:
                                System.out.println("Invalid Input!\n");
                                break;
                        }

                        if (cchoice == 3) {
                            break;
                        }

                    }
                    break;
                case 2:

                    while (true) {
                        System.out.println("\n----Restaurents----");
                        System.out.println("Enter your choice:");
                        System.out.println("1. Login");
                        System.out.println("2. Go Back");

                        int cchoice = in.nextInt();

                        switch (cchoice) {
                            case 1:
                                System.out.println("--Login--");
                                RestaurentDto r = RestaurentController.login();

                                if (r.getName().equals("failed")) {
                                    System.out.println("Login Unsuccessful");
                                    break;
                                } else {
                                    System.out.println("Welcome " + r.getName());
                                }

                                while (true) {
                                    System.out.println("\nEnter your choice:");
                                    System.out.println("1. Add Item");
                                    System.out.println("2. Check Menu Items");
                                    System.out.println("3. Order History");
                                    System.out.println("4. Logout");

                                    int cc = in.nextInt();

                                    switch (cc) {
                                        case 1:
                                            System.out.println("--Add Item to Menu--");
                                            RestaurentController.addItems(r.getEmail(), r.getName());
                                            break;
                                        case 2:
                                            System.out.println("--Check Menu Items--");
                                            RestaurentController.checkItems(r.getEmail());
                                            break;
                                        case 3:
                                            System.out.println("--Order History--");
                                            RestaurentController.printOrderHistory(r.getEmail());
                                            break;
                                        case 4:
                                            System.out.println("Logging out");
                                            break;
                                        default:
                                            System.out.println("Invalid Input!\n");
                                    }

                                    if (cc == 4) {
                                        break;
                                    }

                                }
                                break;
                            case 2:
                                System.out.println("Going Back");
                                break;
                            default:
                                System.out.println("Invalid Input!\n");
                                break;
                        }

                        if (cchoice == 2) {
                            break;
                        }

                    }

                    break;

                case 3:

                    if (!AdminController.login()) {
                        System.out.println("Wrong Password!");
                        break;
                    }
                    System.out.println("\nLogin Successful...");

                    while (true) {
                        System.out.println("\n---Admin---");
                        System.out.println("1. Add Restaurent");
                        System.out.println("2. Logout");

                        int cchoice = in.nextInt();

                        switch (cchoice) {
                            case 1:
                                System.out.println("--Add Restaurent--");
                                AdminController.addRestaurent();
                                System.out.println("Restaurent Added Successfully!");
                                break;
                            case 2:
                                System.out.println("Going Back");
                                break;
                            default:
                                System.out.println("Invalid Input!\n");
                                break;
                        }

                        if (cchoice == 2) {
                            break;
                        }

                    }

                    break;
                default:
                    System.out.println("Invalid Input!\n");

                    break;
            }
        }
    }
}
