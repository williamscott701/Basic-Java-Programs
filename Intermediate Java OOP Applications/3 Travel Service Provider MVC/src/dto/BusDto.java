package dto;

public class BusDto extends TransportVehicleDto {

    private String busName;

    public BusDto(String busName, int vehcleId, int totalNumberOfSeats, String vehicleCompanyId, int numberofSeatsRemaining, String source, String Destination, int price) {
        super(vehcleId, totalNumberOfSeats, vehicleCompanyId, numberofSeatsRemaining, source, Destination, price);
        this.busName = busName;
    }

    public BusDto(int vehcleId) {
        super(vehcleId);
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

}
