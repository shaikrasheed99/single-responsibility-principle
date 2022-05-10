import java.util.ArrayList;

public class ParkingLot {
    private final CAPACITY capacity;
    public ArrayList<Vehicle> vehicles;
    private ParkingService parkingService;

    public ParkingLot(CAPACITY ten) {
        this.capacity = ten;
    }

    public ParkingService getParkingService() {
        return this.parkingService;
    }

    public void setParkingService(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    public void park(Vehicle vehicle) {
        parkingService.parkVehicleIn(this, vehicle);
    }
}
