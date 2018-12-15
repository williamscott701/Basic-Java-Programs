package controller;

import static oopdassignment3.OOPDAssignment3.in;
import dto.CustomerDto;
import dto.JourneyDto;
import java.math.BigInteger;
import interfaces.UserOperations;
import java.time.LocalDate;
import java.util.HashMap;

public class CustomerController extends Thread implements UserOperations {

    @Override
    public Object login() {

        System.out.println("Enter Email");
        String email = in.next();
        System.out.println("Enter Password");
        String password = in.next();

        CustomerDto c = DatabaseController.getCustomer(new CustomerDto(email));
        if (c == null) {
            return null;
        } else if (c.getPassword() == password.hashCode()) {
            return c;
        } else {
            return null;
        }
    }

    @Override
    public CustomerDto signup() {
        System.out.println("Enter Name:");
        String name = in.next();
        System.out.println("Enter Email");
        String email = in.next();
        System.out.println("Enter Mobile");
        BigInteger mobile = in.nextBigInteger();
        System.out.println("Enter Password");
        String password = in.next();

        return DatabaseController.addCustomer(new CustomerDto(email.hashCode(), name, email, mobile, password.hashCode()));
    }

    @Override
    public void logout() {
        System.out.println("Logging out");
    }

    public static void getOrderHistory(int userid) {
        System.out.println("Journey ID\tPassenger\tAge\tUser ID\tCompany ID\tVehicle ID\tDate\t\tFare\tCoupon\tService");
        HashMap j = DatabaseController.getAllJournies();
        for (Object value : j.values()) {
            JourneyDto b = (JourneyDto) value;
            if (b.getUserid() == userid) {
                System.out.println(b.getJouneyid() + "\t" + b.getPassenger() + "\t\t" + b.getAge() + "\t" + b.getUserid() + "\t" + b.getCompanyid() + "\t\t" + b.getVehicleid() + "\t\t" + b.getDate() + "\t" + b.getFarePaid() + "\t" + b.getCoupon() + "\t" + b.getVelhicle());
            }
        }
    }

    public static void getCOrderHistory(int userid) {
        System.out.println("Journey ID\tPassenger\tAge\tUser ID\tCompany ID\tVehicle ID\tDate\t\tFare\tCoupon\tService\tRefund Amount");
        HashMap j = DatabaseController.getAllCJournies();
        for (Object value : j.values()) {
            JourneyDto b = (JourneyDto) value;
            if (b.getUserid() == userid) {
                System.out.println(b.getJouneyid() + "\t" + b.getPassenger() + "\t\t" + b.getAge() + "\t" + b.getUserid() + "\t" + b.getCompanyid() + "\t\t" + b.getVehicleid() + "\t\t" + b.getDate() + "\t" + b.getFarePaid() + "\t" + b.getCoupon() + "\t" + b.getVelhicle() + "\t" + b.getRefundAmount());
            }
        }
    }

    public void cancelBooking(CustomerDto c) {
        getOrderHistory(c.getCustomerId());
        System.out.println("\nEnter The Journey ID you want to cancel");
        int s = in.nextInt();
        HashMap j = DatabaseController.getAllJournies();
        JourneyDto newJ = (JourneyDto) j.get(s);

        j.remove(s);
        int refund = newJ.getFarePaid();
        if (newJ.getDate().isEqual(LocalDate.now())) {
            System.out.println("Bro, you are cancelling a ticket for today. We are extremely sorry, your refund amount is 0");
            refund = 0;
        } else {
            switch (newJ.getVelhicle()) {
                case "Bus":
                    System.out.println("Deducting 80rs");
                    refund -= 80;
                    break;
                case "Train":
                    System.out.println("Deducting 60rs");
                    refund -= 60;
                    break;
                case "Flight":
                    System.out.println("Deducting 400rs");
                    refund -= 400;
                    break;
            }
        }
        c.setBalance(refund + c.getBalance());
        newJ.setRefundAmount(refund);

        DatabaseController.addCJourney(newJ);
        System.out.println("Deposited in your wallet: " + refund);
        System.out.println("Cancelled your booking. We are upset!");
    }

    public void showProfile(String email) {
        CustomerDto c = DatabaseController.getCustomer(new CustomerDto(email));
        System.out.println("\nYour ID:");
        System.out.println(c.getCustomerId());
        System.out.println("Your Email:");
        System.out.println(c.getEmail());
        System.out.println("Your Mobile Number:");
        System.out.println(c.getMobile());
        System.out.println("Your Name:");
        System.out.println(c.getName());
        System.out.println("Your Password Hash:");
        System.out.println(c.getPassword());
        System.out.println("Your Wallet Balance:");
        System.out.println(c.getBalance());
        System.out.println("**Note: dont worry, no one can reverse engineer your password hash even if they peeped your password. :D");
    }
}
