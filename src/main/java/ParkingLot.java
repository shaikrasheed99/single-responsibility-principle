public class ParkingLot {
    private final CAPACITY capacity;
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
}
