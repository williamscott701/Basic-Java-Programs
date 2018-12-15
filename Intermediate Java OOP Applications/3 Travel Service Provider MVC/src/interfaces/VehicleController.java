package interfaces;

import dto.CompanyDto;

public interface VehicleController {

    abstract void addVehicle(CompanyDto c);

    abstract void printMyVehicles(CompanyDto c);

    abstract void printAllVehicles();

}
