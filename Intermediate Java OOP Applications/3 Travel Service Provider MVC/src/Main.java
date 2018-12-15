
import controller.AdminController;
import controller.CustomerController;
import controller.CompanyController;
import controller.CouponController;
import controller.DatabaseController;
import controller.JourneyController;
import dto.CompanyDto;
import dto.CustomerDto;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);
    static CustomerController customerController = new CustomerController();
    static CompanyController companyController = new CompanyController();
    static AdminController adminController = new AdminController();
    static JourneyController journeyController = new JourneyController();

    public static void main(String[] args) {

        DatabaseController.generateData();

        System.out.println("WS OOPD Assignment 2");

        while (true) {
            try {
                System.out.println("\n****Main Menu****");
                System.out.println("Enter your choice:");
                System.out.println("1. Customer");
                System.out.println("2. Company");
                System.out.println("3. Admin");

                int choice = in.nextInt();

                switch (choice) {
                    case 1:

                        while (true) {
                            try {
                                System.out.println("\n----Customer----");
                                System.out.println("\nEnter your choice:");
                                System.out.println("1. Login");
                                System.out.println("2. Signup");
                                System.out.println("3. Go Back");

                                int cchoice = in.nextInt();

                                switch (cchoice) {
                                    case 1:
                                        System.out.println("\n--Login--");
                                        CustomerDto c = (CustomerDto) customerController.login();

                                        if (c == null) {
                                            System.out.println("Login Unsuccessful");
                                            break;
                                        }
                                        while (true) {
                                            System.out.println("\n\n***Welcome " + c.getName() + "***");
                                            System.out.println("\nEnter your choice:");
                                            System.out.println("1. Book Bus");
                                            System.out.println("2. Book Train");
                                            System.out.println("3. Book Flight");
                                            System.out.println("4. Cancel a Booking");
                                            System.out.println("5. Print Book History");
                                            System.out.println("6. Print Cancelled History");
                                            System.out.println("7. Check Profile");
                                            System.out.println("8. Logout");
                                            int cc = in.nextInt();

                                            switch (cc) {
                                                case 1:
                                                    journeyController.addBusBooking(c);
                                                    break;
                                                case 2:
                                                    journeyController.addTrainBooking(c);
                                                    break;
                                                case 3:
                                                    journeyController.addFlightBooking(c);
                                                    break;
                                                case 4:
                                                    customerController.cancelBooking(c);
                                                    break;
                                                case 5:
                                                    System.out.println("---Booking History---");
                                                    CustomerController.getOrderHistory(c.getCustomerId());
                                                    break;
                                                case 6:
                                                    System.out.println("---Cancelled History---");
                                                    CustomerController.getCOrderHistory(c.getCustomerId());
                                                    break;
                                                case 7:
                                                    customerController.showProfile(c.getEmail());
                                                    break;
                                                case 8:
                                                    customerController.logout();
                                                    break;
                                                default:
                                                    System.out.println("Invalid Input!\n");
                                            }

                                            if (cc == 8) {
                                                break;
                                            }

                                        }
                                        break;
                                    case 2:
                                        System.out.println("\n--Signup--");
                                        CustomerDto d = customerController.signup();

                                        if (d.getEmail().equals("failed")) {
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
                            } catch (Exception e) {
                                System.out.println("Invalid Entry");
                                in.next();
                            }
                        }

                        break;

                    case 2:

                        while (true) {
                            try {
                                System.out.println("\n----Companies----");
                                System.out.println("Enter your choice:");
                                System.out.println("1. Login");
                                System.out.println("2. Signup");
                                System.out.println("3. Go Back");

                                int cchoice = in.nextInt();

                                switch (cchoice) {
                                    case 1:
                                        System.out.println("--Login--");
                                        CompanyDto c = (CompanyDto) companyController.login();

                                        if (c == null) {
                                            System.out.println("Login Unsuccessful");
                                            break;
                                        } else {
                                            System.out.println("Welcome " + c.getName());
                                        }

                                        String service = c.getService();

                                        while (true) {
                                            System.out.println("\nEnter your choice:");
                                            System.out.println("1. Add a New " + service);
                                            System.out.println("2. Check all available " + service + "'s");
                                            System.out.println("3. Order History");
                                            System.out.println("4. Add Coupon");
                                            System.out.println("5. Display All Coupons");
                                            System.out.println("6. Check Profile");
                                            System.out.println("7. Logout");

                                            int cc = in.nextInt();

                                            switch (cc) {
                                                case 1:
                                                    System.out.println("--Adding new " + service + "--");
                                                    companyController.addVehicle(c);
                                                    break;
                                                case 2:
                                                    companyController.showMyVehicles(c);
                                                    break;
                                                case 3:
                                                    System.out.println("--Order History--");
                                                    companyController.printCompanyHistory(c.getEmail());
                                                    break;
                                                case 4:
                                                    CouponController.addCouponByCompany(c.getEmail());
                                                    break;
                                                case 5:
                                                    CouponController.displayAllCouponByCompany(c.getEmail());
                                                    break;
                                                case 6:
                                                    System.out.println("--Profile--");
                                                    companyController.printProfile(c.getEmail());
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
                                        companyController.signup();
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
                            } catch (Exception e) {
                                System.out.println("Invalid Entry");
                                in.next();
                            }
                        }

                        break;

                    case 3:

                        if (!adminController.login()) {
                            System.out.println("Wrong Password!");
                            break;
                        }
                        System.out.println("\nLogin Successful...");

                        while (true) {
                            System.out.println("\n---Admin---");
                            System.out.println("1. Display all Users");
                            System.out.println("2. Display all Companies");
                            System.out.println("3. Display all Buses");
                            System.out.println("4. Display all Trains");
                            System.out.println("5. Display all Flights");
                            System.out.println("6. Display all Journies");
                            System.out.println("7. Display all Cancelled Journies");
                            System.out.println("8. Add Coupon");
                            System.out.println("9. Remove Coupon");
                            System.out.println("10. Display all Coupons");
                            System.out.println("11. Logout");

                            int cchoice = in.nextInt();

                            switch (cchoice) {
                                case 1:
                                    adminController.listAllCustomers();
                                    break;
                                case 2:
                                    adminController.listAllCompanies();
                                    break;
                                case 3:
                                    adminController.listAllBuses();
                                    break;
                                case 4:
                                    adminController.listAllTrains();
                                    break;
                                case 5:
                                    adminController.listAllFlights();
                                    break;
                                case 6:
                                    adminController.listAllJourneys();
                                    break;
                                case 7:
                                    adminController.listAllCancelledJournies();
                                    break;
                                case 8:
                                    CouponController.addCouponByAdmin();
                                    break;
                                case 9:
                                    CouponController.removeCouponByAdmin();
                                    break;
                                case 10:
                                    CouponController.displayAllCouponByAdmin();
                                    break;
                                case 11:
                                    System.out.println("Logout");
                                    break;
                                default:
                                    System.out.println("Invalid Input!\n");
                                    break;
                            }

                            if (cchoice == 11) {
                                break;
                            }

                        }
                        break;
                    default:
                        System.out.println("Invalid Input!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Entry");
                in.next();
            }
        }
    }
}
