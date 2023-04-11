package api;
import services.CustomerService;
import services.ReservationService;
import classes.*;

public class HotelResource {
    private static HotelResource hotelResource = new HotelResource();
    public static HotelResource getHotelResource() {
        return hotelResource;
    }

    public Customer getCustomer(String email) {
        CustomerService.getCustomerService().getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        CustomerService.getCustomerService().addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        ReservationService.getReservationService().getARoom(roomNumber);
    }
}
