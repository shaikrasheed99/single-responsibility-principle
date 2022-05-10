import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {
    @Test
    void shouldBeAbleToHaveInstanceOfParkingService() {
        ParkingLot parkingLot = new ParkingLot(CAPACITY.TEN);

        parkingLot.setParkingService(new ParkingService());
        ParkingService parkingService = parkingLot.getParkingService();

        assertTrue(parkingService instanceof ParkingService);
    }
}
