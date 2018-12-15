package interfaces;

import dto.CustomerDto;

public interface Planner {

    public void addBusBooking(CustomerDto c);

    public void addTrainBooking(CustomerDto c);

    public void addFlightBooking(CustomerDto c);

}
