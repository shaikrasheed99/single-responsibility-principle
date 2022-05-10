import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ParkingLotTest {
    @Test
    void shouldBeAbleToHaveNotificationService() {
        ParkingLot parkingLot = new ParkingLot(CAPACITY.TEN);
        NotificationService mockedNotificationService = mock(NotificationService.class);

        parkingLot.setNotificationService(mockedNotificationService);
        NotificationService notificationService = parkingLot.getNotificationService();

        assertNotNull(notificationService);
    }

    @Test
    void shouldBeAbleToSendNotificationToOwnerWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(CAPACITY.TEN);
        NotificationService mockedNotificationService = mock(NotificationService.class);
        Owner owner = new Owner();

        parkingLot.setNotificationService(mockedNotificationService);
        parkingLot.setOwner(owner);
        parkingLot.notifyOwner();

        verify(mockedNotificationService, times(1)).sendNotificationTo(owner);
    }

    @Nested
    class ParkingServiceTests {
        private ParkingLot parkingLot;
        private ParkingService mockedParkingService;

        @BeforeEach
        void setUpParkingServiceInParkingLot() {
            parkingLot = new ParkingLot(CAPACITY.TEN);
            mockedParkingService = mock(ParkingService.class);

            parkingLot.setParkingService(mockedParkingService);
        }

        @Test
        void shouldBeAbleToHaveInstanceOfParkingService() {
            ParkingService parkingService = parkingLot.getParkingService();

            assertNotNull(parkingService);
        }

        @Test
        void shouldBeAbleToParkAVehicleUsingParkingService() {
            Vehicle vehicle = new Vehicle();

            parkingLot.park(vehicle);

            verify(mockedParkingService, times(1)).parkVehicleIn(parkingLot, vehicle);
        }

    }

    @Nested
    class UnparkingServiceTest {
        private ParkingLot parkingLot;
        private UnparkingService mockedUnparkingService;

        @BeforeEach
        void setUpUnparkingServiceInParkingLot() {
            parkingLot = new ParkingLot(CAPACITY.TEN);
            mockedUnparkingService = mock(UnparkingService.class);

            parkingLot.setUnparkingService(mockedUnparkingService);
        }

        @Test
        void shouldBeAbleToHaveInstanceOfUnparkingService() {
            UnparkingService unparkingService = parkingLot.getUnparkingService();

            assertNotNull(unparkingService);
        }

        @Test
        void shouldBeAbleToUnparkUsingUnparkingService() {
            Vehicle vehicle = new Vehicle();

            parkingLot.unpark(vehicle);

            verify(mockedUnparkingService, times(1)).unparkVehicleFrom(parkingLot, vehicle);
        }
    }
}
