package controller;

import static oopdassignment3.OOPDAssignment3.in;
import dto.BusDto;
import dto.CompanyDto;
import dto.CustomerDto;
import interfaces.VehicleController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class BusController implements VehicleController {

    public static void addBooking(CustomerDto c) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            System.out.println("Enter Source");
            String src = in.next();
            System.out.println("Enter Destination");
            String dest = in.next();
            System.out.println("Enter Date (dd-mm)");
            LocalDate date = LocalDate.parse(in.next() + "-2018", formatter);
            LocalDate now = LocalDate.now();
            if (date.isAfter(now)) {

                HashMap buse = DatabaseController.getAllBuses();
                int k = 0;
                for (Object value : buse.values()) {
                    BusDto b = (BusDto) value;
                    if (b.getSource().equals(src) && b.getDestination().equals(dest)) {
                        k++;
                    }
                }

                if (k == 0) {
                    System.out.println("\nNo Buses this route! Sorry :(");
                } else {
                    System.out.println("Bus ID\tName\tSeats\tRemaining\tSrc\tDest\tFare\tCompany");
                    HashMap buses = DatabaseController.getAllBuses();
                    for (Object value : buses.values()) {
                        BusDto b = (BusDto) value;
                        if (b.getSource().equals(src) && b.getDestination().equals(dest)) {
                            System.out.println(b.getVehcleId() + "\t" + b.getBusName() + "\t" + b.getTotalNumberOfSeats() + "\t" + b.getNumberofSeatsRemaining() + "\t\t" + b.getSource() + "\t" + b.getDestination() + "\t" + b.getPrice() + "\t" + b.getVehicleCompanyId());
                        }
                    }
                    System.out.println("\nEnter the Bus ID");
                    int busid = in.nextInt();
                    BusDto b = DatabaseController.getBus(new BusDto(busid));
                    if (b.getSource().equals(src) && b.getDestination().equals(dest)) {
                        System.out.println("Dude! you cannot travel in buses i didnt show");
                    }
                }
            } else {
                System.out.println("I Cannot travel back in time, Sorry! Try a different date.");
            }
        } catch (Exception e) {
            System.out.println("Invalid Entry, Please Enter Again!");
        }

    }

    @Override
    public void addVehicle(CompanyDto c) {
        System.out.println("Enter Bus Name");
        String busName = in.next();
        System.out.println("Enter totalNumberOfSeats");
        int totalNumberOfSeats = in.nextInt();
        System.out.println("Enter Source");
        String source = in.next();
        System.out.println("Enter Destination");
        String destination = in.next();
        System.out.println("Enter Fare");
        int fare = in.nextInt();

        DatabaseController.addBus(new BusDto(busName, busName.hashCode(), totalNumberOfSeats, c.getEmail(), totalNumberOfSeats, source, destination, fare));
    }

    @Override
    public void printMyVehicles(CompanyDto c) {

        System.out.println("Bus ID\tName\tSeats\tRemaining\tSrc\tDest\tFare\tCompany");
        HashMap buses = DatabaseController.getAllBuses();
        for (Object value : buses.values()) {
            BusDto b = (BusDto) value;
            if (b.getVehicleCompanyId().equals(c.getEmail())) {
                System.out.println(b.getVehcleId() + "\t" + b.getBusName() + "\t" + b.getTotalNumberOfSeats() + "\t" + b.getNumberofSeatsRemaining() + "\t\t" + b.getSource() + "\t" + b.getDestination() + "\t" + b.getPrice() + "\t" + b.getVehicleCompanyId());
            }
        }
    }

    @Override
    public void printAllVehicles() {

        System.out.println("Bus ID\tName\tSeats\tRemaining\tSrc\tDest\tFare\tCompany");
        HashMap buses = DatabaseController.getAllBuses();
        for (Object value : buses.values()) {
            BusDto b = (BusDto) value;
            System.out.println(b.getVehcleId() + "\t" + b.getBusName() + "\t" + b.getTotalNumberOfSeats() + "\t" + b.getNumberofSeatsRemaining() + "\t\t" + b.getSource() + "\t" + b.getDestination() + "\t" + b.getPrice() + "\t" + b.getVehicleCompanyId());
        }
    }

}
