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

    @Nested
    class UnparkingServiceTest {
        @Test
        void shouldBeAbleToHaveInstanceOfUnparkingService() {
            ParkingLot parkingLot = new ParkingLot(CAPACITY.TEN);

            parkingLot.setUnparkingService(new UnparkingService());
            UnparkingService unparkingService = parkingLot.getUnparkingService();

            assertNotNull(unparkingService);
        }

        @Test
        void shouldBeAbleToUnparkUsingUnparkingService() {
            ParkingLot parkingLot = new ParkingLot(CAPACITY.TEN);
            UnparkingService mockedUnparkingService = mock(UnparkingService.class);
            Vehicle vehicle = new Vehicle();

            parkingLot.setUnparkingService(mockedUnparkingService);
            parkingLot.unpark(vehicle);

            verify(mockedUnparkingService, times(1)).unparkVehicleFrom(parkingLot, vehicle);
        }
    }
}
