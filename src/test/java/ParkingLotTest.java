import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ParkingLotTest {
    @Nested
    class ParkingServiceTests {
        @Test
        void shouldBeAbleToHaveInstanceOfParkingService() {
            ParkingLot parkingLot = new ParkingLot(CAPACITY.TEN);

            parkingLot.setParkingService(new ParkingService());
            ParkingService parkingService = parkingLot.getParkingService();

            assertNotNull(parkingService);
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
}
