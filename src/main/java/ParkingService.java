public class ParkingService {
    public void parkVehicleIn(ParkingLot parkingLot, Vehicle vehicle) {
        parkingLot.vehicles.add(vehicle);
    }
}
