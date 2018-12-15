package controller;

import static oopdassignment3.OOPDAssignment3.in;
import dto.CompanyDto;
import dto.TrainDto;
import interfaces.VehicleController;
import java.util.HashMap;

public class TrainController implements VehicleController {

    @Override
    public void addVehicle(CompanyDto c) {
        System.out.println("Enter Train Name");
        String busName = in.next();
        System.out.println("Enter totalNumberOfSeats");
        int totalNumberOfSeats = in.nextInt();
        System.out.println("Enter Source");
        String source = in.next();
        System.out.println("Enter Destination");
        String destination = in.next();
        System.out.println("Enter Fare");
        int fare = in.nextInt();

        DatabaseController.addTrain(new TrainDto(busName, busName.hashCode(), totalNumberOfSeats, c.getEmail(), totalNumberOfSeats, source, destination, fare));
    }

    @Override
    public void printMyVehicles(CompanyDto c) {
        System.out.println("Bus ID\tName\tSeats\tRemaining\tSrc\tDest\tFare\tCompany");
        HashMap trains = DatabaseController.getAllTrains();
        for (Object value : trains.values()) {
            TrainDto b = (TrainDto) value;
            if (b.getVehicleCompanyId().equals(c.getEmail())) {
                System.out.println(b.getVehcleId() + "\t" + b.getTrainName() + "\t" + b.getTotalNumberOfSeats() + "\t" + b.getNumberofSeatsRemaining() + "\t\t" + b.getSource() + "\t" + b.getDestination() + "\t" + b.getPrice() + "\t" + b.getVehicleCompanyId());
            }
        }
    }

    @Override
    public void printAllVehicles() {
        System.out.println("Train ID\t\tName\tSeats\tRemaining\tSrc\tDest\tFare\tCompany");
        HashMap trains = DatabaseController.getAllTrains();
        for (Object value : trains.values()) {
            TrainDto b = (TrainDto) value;
            System.out.println(b.getVehcleId() + "\t" + b.getTrainName() + "\t" + b.getTotalNumberOfSeats() + "\t" + b.getNumberofSeatsRemaining() + "\t\t" + b.getSource() + "\t" + b.getDestination() + "\t" + b.getPrice() + "\t" + b.getVehicleCompanyId());
        }
    }

}
