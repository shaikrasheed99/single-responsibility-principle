import java.util.ArrayList;

public class ParkingLot {
    private final CAPACITY capacity;
    public ArrayList<Vehicle> vehicles;
    private ParkingService parkingService;
    private UnparkingService unparkingService;
    private NotificationService notificationService;

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

    public UnparkingService getUnparkingService() {
        return this.unparkingService;
    }

    public void setUnparkingService(UnparkingService unparkingService) {
        this.unparkingService = unparkingService;
    }

    public void unpark(Vehicle vehicle) {
        this.unparkingService.unparkVehicleFrom(this, vehicle);
    }

    public NotificationService getNotificationService() {
        return this.notificationService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
