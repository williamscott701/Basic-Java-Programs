package controller;

import dto.BusDto;
import dto.CompanyDto;
import dto.CouponDto;
import dto.CustomerDto;
import dto.FlightDto;
import dto.JourneyDto;
import dto.TrainDto;
import java.math.BigInteger;
import java.util.HashMap;

public class DatabaseController {

    private static HashMap customers = new HashMap<String, CustomerDto>();
    private static HashMap companies = new HashMap<String, CompanyDto>();
    private static HashMap journies = new HashMap<String, JourneyDto>();
    private static HashMap cancelledJournies = new HashMap<String, JourneyDto>();
    private static HashMap buses = new HashMap<Integer, BusDto>();
    private static HashMap flights = new HashMap<Integer, FlightDto>();
    private static HashMap trains = new HashMap<Integer, TrainDto>();
    private static HashMap coupons = new HashMap<Integer, CouponDto>();

    public static CouponDto addCoupon(CouponDto c) {
        coupons.put(Math.abs(c.getCoupon()), c);
        return c;
    }

    public static CouponDto getCoupon(CouponDto c) {
        return (CouponDto) coupons.get(c.getCoupon());
    }

    public static HashMap getAllCoupons() {
        return coupons;
    }

    public static JourneyDto addCJourney(JourneyDto journey) {
        cancelledJournies.put(Math.abs(journey.getJouneyid()), journey);
        return journey;
    }

    public static JourneyDto getCJourney(JourneyDto j) {
        return (JourneyDto) cancelledJournies.get(j.getJouneyid());
    }

    public static HashMap getAllCJournies() {
        return cancelledJournies;
    }

    public static JourneyDto addJourney(JourneyDto journey) {
        journies.put(Math.abs(journey.getJouneyid()), journey);
        return journey;
    }

    public static JourneyDto getJourney(JourneyDto j) {
        return (JourneyDto) journies.get(j.getJouneyid());
    }

    public static HashMap getAllJournies() {
        return journies;
    }

    public static CustomerDto addCustomer(CustomerDto customer) {
        customers.put(customer.getEmail(), customer);
        return customer;
    }

    public static CustomerDto getCustomer(CustomerDto customer) {
        return (CustomerDto) customers.get(customer.getEmail());
    }

    public static HashMap getAllCustomers() {
        return customers;
    }

    public static CompanyDto addCompany(CompanyDto companyDto) {
        companies.put(companyDto.getEmail(), companyDto);
        return companyDto;
    }

    public static CompanyDto getCompany(CompanyDto companyDto) {
        return (CompanyDto) companies.get(companyDto.getEmail());
    }

    public static HashMap getAllCompanies() {
        return companies;
    }

    public static BusDto addBus(BusDto busDto) {
        buses.put(Math.abs(busDto.getVehcleId()), busDto);
        return busDto;
    }

    public static BusDto getBus(BusDto busDto) {
        return (BusDto) buses.get(busDto.getVehcleId());
    }

    public static BusDto getBusTemp(BusDto busDto) {
        BusDto a = null;
        for (Object value : buses.values()) {
            BusDto b = (BusDto) value;

            if (b.getVehcleId() == busDto.getVehcleId()) {
                a = b;
            }
        }
        return a;
    }

    public static FlightDto getFlightTemp(FlightDto flightDto) {
        FlightDto a = null;
        for (Object value : flights.values()) {
            FlightDto b = (FlightDto) value;

            if (b.getVehcleId() == flightDto.getVehcleId()) {
                a = b;
            }
        }
        return a;
    }

    static TrainDto getTrainTemp(TrainDto trainDto) {
        TrainDto a = null;
        for (Object value : trains.values()) {
            TrainDto b = (TrainDto) value;
            if (b.getVehcleId() == trainDto.getVehcleId()) {
                a = b;
            }
        }
        return a;
    }

    public static HashMap getAllBuses() {
        return buses;
    }

    public static FlightDto addFlight(FlightDto flightDto) {
        flights.put(Math.abs(flightDto.getVehcleId()), flightDto);
        return flightDto;
    }

    public static FlightDto getFlight(FlightDto flightDto) {
        return (FlightDto) flights.get(flightDto.getVehcleId());
    }

    public static HashMap getAllFlights() {
        System.out.println("A");
        return flights;
    }

    public static TrainDto addTrain(TrainDto trainDto) {
        trains.put(Math.abs(trainDto.getVehcleId()), trainDto);
        return trainDto;
    }

    public static TrainDto getTrain(TrainDto trainDto) {
        return (TrainDto) trains.get(trainDto.getVehcleId());
    }

    public static HashMap getAllTrains() {
        return trains;
    }

    public static void generateData() {
        customers.put("1", new CustomerDto("1".hashCode(), "1", "1", BigInteger.ONE, "1".hashCode()));
        customers.put("2", new CustomerDto("2".hashCode(), "2", "2", BigInteger.ONE, "2".hashCode()));

        companies.put("1", new CompanyDto("1".hashCode(), "1", BigInteger.ONE, BigInteger.ONE, "Bus", "1", "1".hashCode()));
        companies.put("2", new CompanyDto("2".hashCode(), "2", BigInteger.ONE, BigInteger.ONE, "Flight", "2", "2".hashCode()));
        companies.put("3", new CompanyDto("3".hashCode(), "3", BigInteger.ONE, BigInteger.ONE, "Bus", "3", "3".hashCode()));
        companies.put("care@irctc", new CompanyDto("irctc".hashCode(), "irctc", BigInteger.ONE, BigInteger.ONE, "Train", "irctc", "1".hashCode()));

        trains.put("1".hashCode(), new TrainDto("Circar", "Circar".hashCode(), 10, "irctc", 10, "Delhi", "Agra", 1900));

        buses.put("4".hashCode(), new BusDto("4", "4".hashCode(), 40, "1", 40, "Delhi", "Agra", 1800));
        buses.put("5".hashCode(), new BusDto("5", "5".hashCode(), 50, "1", 50, "Delhi", "Agra", 1900));
        buses.put("5".hashCode(), new BusDto("5", "5".hashCode(), 50, "2", 50, "Delhi", "Agra", 1750));

        flights.put(Math.abs("boeing".hashCode()), new FlightDto("boeing", "boeing".hashCode(), 30, "2", 30, "Delhi", "Agra", 3800));

    }

}
