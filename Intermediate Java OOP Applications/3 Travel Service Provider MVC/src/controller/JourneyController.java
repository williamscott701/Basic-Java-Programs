package controller;

import dto.BusDto;
import dto.CouponDto;
import dto.CustomerDto;
import dto.FlightDto;
import dto.JourneyDto;
import dto.TrainDto;
import interfaces.Planner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import static oopdassignment3.OOPDAssignment3.in;

public class JourneyController implements Planner {

    @Override
    public void addBusBooking(CustomerDto c) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            System.out.println("Enter Source");
            String src = in.next();
            System.out.println("Enter Destination");
            String dest = in.next();
            System.out.println("Enter Date (dd-mm)");
            LocalDate date = LocalDate.parse(in.next() + "-2018", formatter);
            LocalDate now = LocalDate.now().minusDays(1);
            if (date.isAfter(now)) {

                HashMap buse = DatabaseController.getAllBuses();
                int k = 0;
                for (Object value : buse.values()) {
                    BusDto b = (BusDto) value;
                    if (b.getSource().equals(src) && b.getDestination().equals(dest) && b.getNumberofSeatsRemaining() > 0) {
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
                        if (b.getSource().equals(src) && b.getDestination().equals(dest) && b.getNumberofSeatsRemaining() > 0) {
                            System.out.println(b.getVehcleId() + "\t" + b.getBusName() + "\t" + b.getTotalNumberOfSeats() + "\t" + b.getNumberofSeatsRemaining() + "\t\t" + b.getSource() + "\t" + b.getDestination() + "\t" + b.getPrice() + "\t" + b.getVehicleCompanyId());
                        }
                    }
                    System.out.println("\nEnter the Bus ID");
                    int busid = in.nextInt();
                    BusDto b = DatabaseController.getBusTemp(new BusDto(busid));
                    if (b == null) {
                        System.out.println("Dude! you cannot travel in buses i didnt show");
                    } else if (b.getSource().equals(src) && b.getDestination().equals(dest) && b.getNumberofSeatsRemaining() > 0) {
                        System.out.println("\nEnter Passenger Details:");
                        System.out.println("Name:");
                        String name = in.next();
                        System.out.println("Age");
                        int age = in.nextInt();
                        System.out.println("Enter 1 if you want to redeem a coupon, else anything else");
                        System.out.println("Note: enter -1 to get out");

                        int choice = in.nextInt();
                        String co = "";
                        int pric = b.getPrice();
                        while (choice == 1) {
                            System.out.println("Enter coupon");
                            int coupon = in.nextInt();
                            if (coupon == -1) {
                                choice = 0;
                            } else {
                                CouponDto cou = DatabaseController.getCoupon(new CouponDto(coupon));
                                if (cou == null) {
                                    System.out.println("\nBro, coupon is invalid! please check");
                                } else if (!cou.getCompanyEmail().equals(b.getVehicleCompanyId())) {
                                    System.out.println("\nThis coupon is not for this company, Not my fault!");
                                } else {
                                    choice = 0;
                                    co = cou.getCoupon() + "";
                                    System.out.println("\nCoupon Applied Succesfully");
                                    System.out.println("Reducing " + cou.getAmount());
                                    pric -= cou.getAmount();
                                }
                            }
                        }
                        JourneyDto j = new JourneyDto(Math.abs((name + LocalDateTime.now()).hashCode()), name, age, c.getCustomerId(), b.getVehicleCompanyId(), b.getVehcleId(), date, pric, co, "Bus");
                        DatabaseController.addJourney(j);
                        System.out.println("Booking Successful");
                        b.setNumberofSeatsRemaining(b.getNumberofSeatsRemaining() - 1);
                    } else {
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
    public void addFlightBooking(CustomerDto c) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            System.out.println("Enter Source");
            String src = in.next();
            System.out.println("Enter Destination");
            String dest = in.next();
            System.out.println("Enter Date (dd-mm)");
            LocalDate date = LocalDate.parse(in.next() + "-2018", formatter);
            LocalDate now = LocalDate.now().minusDays(1);
            if (date.isAfter(now)) {

                HashMap flig = DatabaseController.getAllFlights();
                int k = 0;
                for (Object value : flig.values()) {
                    FlightDto b = (FlightDto) value;
                    if (b.getSource().equals(src) && b.getDestination().equals(dest) && b.getNumberofSeatsRemaining() > 0) {
                        k++;
                    }
                }

                if (k == 0) {
                    System.out.println("\nNo FLights this route! Sorry :(");
                } else {
                    System.out.println("Flight ID\tName\tSeats\tRemaining\tSrc\tDest\tFare\tCompany");
                    HashMap flights = DatabaseController.getAllFlights();
                    for (Object value : flights.values()) {
                        FlightDto b = (FlightDto) value;
                        if (b.getSource().equals(src) && b.getDestination().equals(dest) && b.getNumberofSeatsRemaining() > 0) {
                            System.out.println(b.getVehcleId() + "\t" + b.getFlightName() + "\t" + b.getTotalNumberOfSeats() + "\t" + b.getNumberofSeatsRemaining() + "\t\t" + b.getSource() + "\t" + b.getDestination() + "\t" + b.getPrice() + "\t" + b.getVehicleCompanyId());
                        }
                    }
                    System.out.println("\nEnter the Flight ID");
                    int flightid = in.nextInt();
                    FlightDto b = DatabaseController.getFlightTemp(new FlightDto(flightid));
                    if (b == null) {
                        System.out.println("Dude! you cannot travel in flights i didnt show");
                    } else if (b.getSource().equals(src) && b.getDestination().equals(dest) && b.getNumberofSeatsRemaining() > 0) {
                        System.out.println("\nEnter Passenger Details:");
                        System.out.println("Name:");
                        String name = in.next();
                        System.out.println("Age");
                        int age = in.nextInt();
                        System.out.println("Enter 1 if you want to redeem a coupon, else anything else");
                        System.out.println("Note: enter -1 to get out");

                        int choice = in.nextInt();
                        String co = "";
                        int pric = b.getPrice();
                        while (choice == 1) {
                            System.out.println("Enter coupon");
                            int coupon = in.nextInt();
                            if (coupon == -1) {
                                choice = 0;
                            } else {
                                CouponDto cou = DatabaseController.getCoupon(new CouponDto(coupon));
                                if (cou == null) {
                                    System.out.println("\nBro, coupon is invalid! please check");
                                } else {
                                    choice = 0;
                                    co = cou.getCoupon() + "";
                                    System.out.println("\nCoupon Applied Succesfully");
                                    System.out.println("Reducing " + cou.getAmount());
                                    pric -= cou.getAmount();
                                }
                            }
                        }
                        JourneyDto j = new JourneyDto(Math.abs((name + LocalDateTime.now()).hashCode()), name, age, c.getCustomerId(), b.getVehicleCompanyId(), b.getVehcleId(), date, pric, co, "Flight");
                        DatabaseController.addJourney(j);
                        System.out.println("Booking Successful");
                        b.setNumberofSeatsRemaining(b.getNumberofSeatsRemaining() - 1);
                    } else {
                        System.out.println("Dude! you cannot travel in flights i didnt show");
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
    public void addTrainBooking(CustomerDto c) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            System.out.println("Enter Source");
            String src = in.next();
            System.out.println("Enter Destination");
            String dest = in.next();
            System.out.println("Enter Date (dd-mm)");
            LocalDate date = LocalDate.parse(in.next() + "-2018", formatter);
            LocalDate now = LocalDate.now().minusDays(1);
            if (date.isAfter(now)) {

                HashMap tra = DatabaseController.getAllTrains();
                int k = 0;
                for (Object value : tra.values()) {
                    TrainDto b = (TrainDto) value;
                    if (b.getSource().equals(src) && b.getDestination().equals(dest) && b.getNumberofSeatsRemaining() > 0) {
                        k++;
                    }
                }

                if (k == 0) {
                    System.out.println("\nNo Trains this route! Sorry :(");
                } else {
                    System.out.println("Train ID\tName\tSeats\tRemaining\tSrc\tDest\tFare\tCompany");
                    HashMap trains = DatabaseController.getAllTrains();
                    for (Object value : trains.values()) {
                        TrainDto b = (TrainDto) value;
                        if (b.getSource().equals(src) && b.getDestination().equals(dest) && b.getNumberofSeatsRemaining() > 0) {
                            System.out.println(b.getVehcleId() + "\t" + b.getTrainName() + "\t" + b.getTotalNumberOfSeats() + "\t" + b.getNumberofSeatsRemaining() + "\t\t" + b.getSource() + "\t" + b.getDestination() + "\t" + b.getPrice() + "\t" + b.getVehicleCompanyId());
                        }
                    }
                    System.out.println("\nEnter the Train ID");
                    int trainid = in.nextInt();
                    TrainDto b = DatabaseController.getTrainTemp(new TrainDto(trainid));
                    if (b == null) {
                        System.out.println("Dude! you cannot travel in trains i didnt show");
                    } else if (b.getSource().equals(src) && b.getDestination().equals(dest) && b.getNumberofSeatsRemaining() > 0) {
                        System.out.println("\nEnter Passenger Details:");
                        System.out.println("Name:");
                        String name = in.next();
                        System.out.println("Age");
                        int age = in.nextInt();
                        System.out.println("Enter 1 if you want to redeem a coupon, else anything else");
                        System.out.println("Note: enter -1 to get out");

                        int choice = in.nextInt();
                        String co = "";
                        int pric = b.getPrice();
                        while (choice == 1) {
                            System.out.println("Enter coupon");
                            int coupon = in.nextInt();
                            if (coupon == -1) {
                                choice = 0;
                            } else {
                                CouponDto cou = DatabaseController.getCoupon(new CouponDto(coupon));
                                if (cou == null) {
                                    System.out.println("\nBro, coupon is invalid! please check");
                                } else {
                                    choice = 0;
                                    co = cou.getCoupon() + "";
                                    System.out.println("\nCoupon Applied Succesfully");
                                    System.out.println("Reducing " + cou.getAmount());
                                    pric -= cou.getAmount();
                                }
                            }
                        }
                        JourneyDto j = new JourneyDto(Math.abs((name + LocalDateTime.now()).hashCode()), name, age, c.getCustomerId(), b.getVehicleCompanyId(), b.getVehcleId(), date, pric, co, "Train");
                        DatabaseController.addJourney(j);
                        System.out.println("Booking Successful");
                        b.setNumberofSeatsRemaining(b.getNumberofSeatsRemaining() - 1);
                    } else {
                        System.out.println("Dude! you cannot travel in trains i didnt show");
                    }
                }
            } else {
                System.out.println("I Cannot travel back in time, Sorry! Try a different date.");
            }
        } catch (Exception e) {
            System.out.println("Invalid Entry, Please Enter Again!");
        }
    }
}
