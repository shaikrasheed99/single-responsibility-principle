public class UnparkingService {
    public void unparkVehicleFrom(ParkingLot parkingLot, Vehicle vehicle) {
        parkingLot.vehicles.remove(vehicle);
    }
}
