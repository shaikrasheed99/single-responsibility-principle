import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ParkingLotTest {
    @Test
    void shouldBeAbleToHaveInstanceOfParkingService() {
        ParkingLot parkingLot = new ParkingLot(CAPACITY.TEN);

        parkingLot.setParkingService(new ParkingService());
        ParkingService parkingService = parkingLot.getParkingService();

        assertTrue(parkingService instanceof ParkingService);
    }

    @Test
    void shouldBeAbleToParkAVehicleUsingParkingService() {
        ParkingLot parkingLot = new ParkingLot(CAPACITY.TEN);
        ParkingService mockedParkingService = mock(ParkingService.class);
        Vehicle vehicle = new Vehicle();

        parkingLot.setParkingService(mockedParkingService);
        parkingLot.park(vehicle);

        verify(mockedParkingService, times(1)).parkVehicleIn(parkingLot, vehicle);
    }
}
