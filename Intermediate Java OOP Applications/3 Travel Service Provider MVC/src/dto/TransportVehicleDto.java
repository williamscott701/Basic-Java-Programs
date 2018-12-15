package dto;

public class TransportVehicleDto {

    private int vehcleId;
    private int totalNumberOfSeats;
    private String vehicleCompanyId;
    private int numberofSeatsRemaining;
    private String source;
    private String Destination;
    private int price;

    public TransportVehicleDto(int vehcleId, int totalNumberOfSeats, String vehicleCompanyId, int numberofSeatsRemaining, String source, String Destination, int price) {
        this.vehcleId = vehcleId;
        this.totalNumberOfSeats = totalNumberOfSeats;
        this.vehicleCompanyId = vehicleCompanyId;
        this.numberofSeatsRemaining = numberofSeatsRemaining;
        this.source = source;
        this.Destination = Destination;
        this.price = price;
    }

    public TransportVehicleDto(int vehcleId) {
        this.vehcleId = vehcleId;
    }

    public int getVehcleId() {
        return vehcleId;
    }

    public void setVehcleId(int vehcleId) {
        this.vehcleId = vehcleId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getVehicleCompanyId() {
        return vehicleCompanyId;
    }

    public void setVehicleCompanyId(String vehicleCompanyId) {
        this.vehicleCompanyId = vehicleCompanyId;
    }

    public int getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public int getNumberofSeatsRemaining() {
        return numberofSeatsRemaining;
    }

    public void setNumberofSeatsRemaining(int numberofSeatsRemaining) {
        this.numberofSeatsRemaining = numberofSeatsRemaining;
    }

}
