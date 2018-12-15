package controller;

import static oopdassignment3.OOPDAssignment3.in;
import dto.CompanyDto;
import dto.CustomerDto;
import dto.JourneyDto;
import java.util.HashMap;

public class AdminController {

    BusController busController = new BusController();
    TrainController trainController = new TrainController();
    FlightController flightController = new FlightController();

    public boolean login() {
        System.out.println("Enter Password");
        int c = in.nextInt();
        return c == 1234;
    }

    public void listAllCustomers() {
        System.out.println("Customer ID\tName\tEmail\tMobile\tPassword Hash");
        HashMap customers = DatabaseController.getAllCustomers();
        for (Object value : customers.values()) {
            CustomerDto b = (CustomerDto) value;
            System.out.println(b.getCustomerId() + "\t\t" + b.getName() + "\t" + b.getEmail() + "\t" + b.getMobile() + "\t" + b.getPassword());
        }
    }

    public void listAllCompanies() {
        System.out.println("Company ID\tName\tContact Number\tCustomer Care\tService Type\tEmail\tPassword Hash");
        HashMap companies = DatabaseController.getAllCompanies();
        for (Object value : companies.values()) {
            CompanyDto b = (CompanyDto) value;
            System.out.println(b.getEmail().hashCode() + "\t\t" + b.getName() + "\t" + b.getCompanyContactNumber() + "\t\t" + b.getCustomerCareNumber() + "\t\t" + b.getService() + "\t\t" + b.getEmail() + "\t" + b.getPassword());
        }
    }

    public void listAllJourneys() {
        System.out.println("Journey ID\tPassenger\tAge\tUser ID\tCompany ID\tVehicle ID\tDate\t\tFare\tCoupon\tService");
        HashMap j = DatabaseController.getAllJournies();
        for (Object value : j.values()) {
            JourneyDto b = (JourneyDto) value;
            System.out.println(b.getJouneyid() + "\t" + b.getPassenger() + "\t\t" + b.getAge() + "\t" + b.getUserid() + "\t" + b.getCompanyid() + "\t\t" + b.getVehicleid() + "\t\t" + b.getDate() + "\t" + b.getFarePaid() + "\t" + b.getCoupon() + "\t" + b.getVelhicle());
        }
    }

    public void listAllBuses() {
        busController.printAllVehicles();
    }

    public void listAllFlights() {
        flightController.printAllVehicles();
    }

    public void listAllTrains() {
        trainController.printAllVehicles();
    }

    public void listAllCancelledJournies() {
        System.out.println("Journey ID\tPassenger\tAge\tUser ID\tCompany ID\tVehicle ID\tDate\t\tFare\tCoupon\tService");
        HashMap j = DatabaseController.getAllCJournies();
        for (Object value : j.values()) {
            JourneyDto b = (JourneyDto) value;
            System.out.println(b.getJouneyid() + "\t" + b.getPassenger() + "\t\t" + b.getAge() + "\t" + b.getUserid() + "\t" + b.getCompanyid() + "\t\t" + b.getVehicleid() + "\t\t" + b.getDate() + "\t" + b.getFarePaid() + "\t" + b.getCoupon() + "\t" + b.getVelhicle());
        }
    }

}
