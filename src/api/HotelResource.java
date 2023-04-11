package api;
import services.CustomerService;
import services.ReservationService;
import classes.Room;
import models.IRoom;
import classes.Customer;
import classes.Reservation

import java.util.Date;

public class HotelResource {
    private static HotelResource hotelResource = new HotelResource();
    public static HotelResource getHotelResource() {
        return hotelResource;
    }

    public Customer getCustomer(String email) {
       return CustomerService.getCustomerService().getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        CustomerService.getCustomerService().addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        return ReservationService.getReservationService().getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = getCustomer(customerEmail);
       return ReservationService.getReservationService().reserveARoom(customer, room, checkInDate, checkOutDate);
    }
}
