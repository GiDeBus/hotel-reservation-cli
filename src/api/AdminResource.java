package api;

import services.CustomerService;
import services.ReservationService;
import classes.Customer;
import classes.Room;

import java.util.List;

public class AdminResource {
    private static AdminResource adminResource = new AdminResource();
    public static AdminResource getAdminResource() {
        return adminResource;
    }

    public Customer getCustomer(String email) {
        return CustomerService.getCustomerService().getCustomer(email);
    }

    public void addRoom(List<Room> rooms) {
        for (Room room : rooms) {
            ReservationService.getReservationService().addRoom(room);
        }
    }
}
