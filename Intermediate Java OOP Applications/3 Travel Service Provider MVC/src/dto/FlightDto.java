package dto;

public class FlightDto extends TransportVehicleDto {

    private String flightName;

    public FlightDto(String flightName, int vehcleId, int totalNumberOfSeats, String vehicleCompanyId, int numberofSeatsRemaining, String source, String Destination, int price) {
        super(vehcleId, totalNumberOfSeats, vehicleCompanyId, numberofSeatsRemaining, source, Destination, price);
        this.flightName = flightName;
    }

    public FlightDto(int flightid) {
        super(flightid);
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String aFlightName) {
        flightName = aFlightName;
    }

}
