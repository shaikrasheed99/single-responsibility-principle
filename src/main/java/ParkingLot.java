import java.util.ArrayList;

public class ParkingLot {
    private final CAPACITY capacity;
    public ArrayList<Vehicle> vehicles;
    private ParkingService parkingService;
    private UnparkingService unparkingService;
    private NotificationService notificationService;
    private Owner owner;

    public ParkingLot(CAPACITY ten) {
        this.capacity = ten;
    }

    public void park(Vehicle vehicle) {
        parkingService.parkVehicleIn(this, vehicle);
    }

    public void unpark(Vehicle vehicle) {
        this.unparkingService.unparkVehicleFrom(this, vehicle);
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void notifyOwner() {
        if (isFull()) {
            this.notificationService.sendNotificationTo(this.owner);
        }
    }

    public ParkingService getParkingService() {
        return this.parkingService;
    }

    public void setParkingService(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    public UnparkingService getUnparkingService() {
        return this.unparkingService;
    }

    public void setUnparkingService(UnparkingService unparkingService) {
        this.unparkingService = unparkingService;
    }

    public NotificationService getNotificationService() {
        return this.notificationService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    private boolean isFull() {
        return capacity == CAPACITY.TEN;
    }
}
