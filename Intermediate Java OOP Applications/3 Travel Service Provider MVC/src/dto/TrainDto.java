package dto;

public class TrainDto extends TransportVehicleDto {

    private String trainName;

    public TrainDto(String trainName, int vehcleId, int totalNumberOfSeats, String vehicleCompanyId, int numberofSeatsRemaining, String source, String Destination, int price) {
        super(vehcleId, totalNumberOfSeats, vehicleCompanyId, numberofSeatsRemaining, source, Destination, price);
        this.trainName = trainName;
    }

    public TrainDto(int trainid) {
        super(trainid);
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

}
