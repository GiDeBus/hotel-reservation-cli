package api;

import services.CustomerService;
import services.ReservationService;
import classes.Customer;
import classes.Room;
import models.IRoom;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    private static AdminResource adminResource = new AdminResource();

    public static AdminResource getAdminResource() {
        return adminResource;
    }

    public Customer getCustomer(String email) {
        return CustomerService.getInstance().getCustomer(email);
    }

    public void addRoom(List<Room> rooms) {
        for (Room room : rooms) {
            ReservationService.getInstance().addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return ReservationService.getInstance().getAllRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return CustomerService.getInstance().getAllCustomers();
    }

    public void displayAllReservations() {
        ReservationService.getInstance().printAllReservations();
    }
}
