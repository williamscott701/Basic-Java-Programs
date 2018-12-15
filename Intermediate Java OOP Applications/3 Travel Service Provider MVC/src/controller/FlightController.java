package controller;

import static oopdassignment3.OOPDAssignment3.in;
import dto.CompanyDto;
import dto.FlightDto;
import interfaces.VehicleController;
import java.util.HashMap;

public class FlightController implements VehicleController {

    @Override
    public void addVehicle(CompanyDto c) {
        System.out.println("Enter Flight Name");
        String flightName = in.next();
        System.out.println("Enter totalNumberOfSeats");
        int totalNumberOfSeats = in.nextInt();
        System.out.println("Enter Source");
        String source = in.next();
        System.out.println("Enter Destination");
        String destination = in.next();
        System.out.println("Enter Fare");
        int fare = in.nextInt();

        DatabaseController.addFlight(new FlightDto(flightName, flightName.hashCode(), totalNumberOfSeats, c.getEmail(), totalNumberOfSeats, source, destination, fare));
    }

    @Override
    public void printMyVehicles(CompanyDto c) {

        System.out.println("Flight ID\tName\tSeats\tRemaining\tSrc\tDest\tFare\tCompany");
        HashMap flights = DatabaseController.getAllFlights();
        for (Object value : flights.values()) {
            FlightDto f = (FlightDto) value;
            if (f.getVehicleCompanyId().equals(c.getEmail())) {
                System.out.println(f.getVehcleId() + "\t\t" + f.getFlightName() + "\t" + f.getTotalNumberOfSeats() + "\t" + f.getNumberofSeatsRemaining() + "\t\t" + f.getSource() + "\t" + f.getDestination() + "\t" + f.getPrice() + "\t" + f.getVehicleCompanyId());
            }
        }
    }

    @Override
    public void printAllVehicles() {
        System.out.println("Flight ID\tName\tSeats\tRemaining\tSrc\tDest\tFare\tCompany");
        HashMap flights = DatabaseController.getAllFlights();
        for (Object value : flights.values()) {
            FlightDto f = (FlightDto) value;
            System.out.println(f.getVehcleId() + "\t\t" + f.getFlightName() + "\t" + f.getTotalNumberOfSeats() + "\t" + f.getNumberofSeatsRemaining() + "\t\t" + f.getSource() + "\t" + f.getDestination() + "\t" + f.getPrice() + "\t" + f.getVehicleCompanyId());
        }
    }

}
