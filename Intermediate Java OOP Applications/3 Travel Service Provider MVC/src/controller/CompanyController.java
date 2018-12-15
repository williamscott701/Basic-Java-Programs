package controller;

import static oopdassignment3.OOPDAssignment3.in;
import dto.CompanyDto;
import dto.JourneyDto;
import interfaces.UserOperations;
import java.math.BigInteger;
import java.util.HashMap;

public class CompanyController implements UserOperations {

    BusController busController = new BusController();
    TrainController trainController = new TrainController();
    FlightController flightController = new FlightController();

    @Override
    public Object login() {

        System.out.println("Enter Email");
        String email = in.next();
        System.out.println("Enter Password");
        String password = in.next();

        CompanyDto c = DatabaseController.getCompany(new CompanyDto(email));
        if (c == null) {
            return null;
        } else if (c.getPassword() == password.hashCode()) {
            return c;
        } else {
            return null;
        }
    }

    @Override
    public Object signup() {
        System.out.println("Enter Name:");
        String name = in.next();
        System.out.println("Enter Email");
        String email = in.next();

        System.out.println("Service Type:\n- Enter 1 for Bus\n- Anything else for Flight");
        String s = in.next();
        String service = null;
        if (s.equals("1")) {
            service = "Bus";
        } else {
            service = "Flight";
        }
        System.out.println("Enter Company Contact Number");
        BigInteger contactNumber = in.nextBigInteger();
        System.out.println("Enter Company Customer Care Number");
        BigInteger customerCareNumber = in.nextBigInteger();
        System.out.println("Enter Password");
        String password = in.next();

        return DatabaseController.addCompany(new CompanyDto(email.hashCode(), name, contactNumber, customerCareNumber, service, email, password.hashCode()));

    }

    public void addVehicle(CompanyDto c) {
        switch (c.getService()) {
            case "Bus":
                busController.addVehicle(c);
                break;
            case "Train":
                trainController.addVehicle(c);
                break;
            case "Flight":
                flightController.addVehicle(c);
                break;
            default:
                break;
        }

    }

    public void showMyVehicles(CompanyDto c) {
        switch (c.getService()) {
            case "Bus":
                System.out.println("--Showing all your Buses--");
                busController.printMyVehicles(c);
                break;
            case "Train":
                trainController.printMyVehicles(c);
                break;
            case "Flight":
                flightController.printMyVehicles(c);
                break;
            default:
                break;
        }
    }

    @Override
    public void logout() {
        System.out.println("Logging out");
    }

    public void printCompanyHistory(String companyId) {
        System.out.println("Journey ID\tPassenger\tAge\tUser ID\tCompany ID\tVehicle ID\tDate\t\tFare\tCoupon");
        HashMap j = DatabaseController.getAllJournies();
        for (Object value : j.values()) {
            JourneyDto b = (JourneyDto) value;
            if (b.getCompanyid().equals(companyId)) {
                System.out.println(b.getJouneyid() + "\t" + b.getPassenger() + "\t\t" + b.getAge() + "\t" + b.getUserid() + "\t" + b.getCompanyid() + "\t\t" + b.getVehicleid() + "\t\t" + b.getDate() + "\t" + b.getFarePaid() + "\t" + b.getCoupon());
            }
        }
    }

    public void printProfile(String email) {
        CompanyDto c = DatabaseController.getCompany(new CompanyDto(email));
        System.out.println("Your Contact Number:");
        System.out.println(c.getCompanyContactNumber());
        System.out.println("Your Email:");
        System.out.println(c.getEmail());
        System.out.println("Your Customer Care Number:");
        System.out.println(c.getCustomerCareNumber());
        System.out.println("Your Name:");
        System.out.println(c.getName());
        System.out.println("Your Password Hash:");
        System.out.println(c.getPassword());
        System.out.println("Your Service:");
        System.out.println(c.getService());
        System.out.println("\n*Note: dont worry, no one can reverse engineer your password hash even if they peeped your password. :D");
    }

}
